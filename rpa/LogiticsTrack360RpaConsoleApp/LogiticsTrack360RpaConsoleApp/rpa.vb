Imports System.Configuration
Imports Oracle.ManagedDataAccess.Client

Module RpaUpdateModule
    Sub Main()
        Dim connStr As String = ConfigurationManager.ConnectionStrings("OracleDbConnection").ConnectionString
        Using conn As New OracleConnection(connStr)
            conn.Open()
            Using trans As OracleTransaction = conn.BeginTransaction()
                Try
                    Dim insertHistorySql As String = "
                      INSERT INTO TBL_ORDER_STATUS_HISTORY (
                          HISTORY_ID,
                          ORDER_ID,
                          STATUS,
                          UPDATED_BY,
                          UPDATED_AT
                      )
                      SELECT
                          SEQ_HISTORY_ID.NEXTVAL,
                          ORDER_ID,
                          'COMPLETED',
                          'RPA',
                          SYSDATE
                      FROM TBL_ORDER
                      WHERE STATUS = 'DELIVERED'
                      AND UPDATED_AT <= SYSDATE - (5/1440)
                      "
                    ExecuteNonQuery(conn, insertHistorySql, trans)

                    Dim updateOrderSql As String = "
                      UPDATE TBL_ORDER
                      SET STATUS = 'COMPLETED', UPDATED_AT = SYSDATE
                      WHERE STATUS = 'DELIVERED'
                      AND UPDATED_AT <= SYSDATE - (5/1440)
                      "
                    ExecuteNonQuery(conn, updateOrderSql, trans)

                    Dim updateShipmentSql As String = "
                      UPDATE TBL_SHIPMENT S
                      SET S.SHIPMENT_STATUS = 'DELIVERED',
                          S.UPDATED_AT = SYSDATE
                      WHERE S.SHIPMENT_STATUS = 'IN_TRANSIT'
                      AND S.UPDATED_AT <= SYSDATE - (5/1440)
                      "
                    ExecuteNonQuery(conn, updateShipmentSql, trans)


                    Dim updateRelatedOrdersSql As String = "
                      UPDATE TBL_ORDER O
                      SET O.STATUS = 'DELIVERED',
                          O.UPDATED_AT = SYSDATE
                      WHERE O.STATUS = 'DISPATCHED'
                      AND EXISTS (
                          SELECT 1 FROM TBL_SHIPMENT S
                          WHERE S.ORDER_ID = O.ORDER_ID
                          AND S.SHIPMENT_STATUS = 'DELIVERED'
                      )
                      "
                    ExecuteNonQuery(conn, updateRelatedOrdersSql, trans)

                    trans.Commit()
                    Console.WriteLine("RPA 갱신이 성공적으로 수행되었습니다.")

                Catch ex As Exception
                    trans.Rollback()
                    Console.WriteLine("오류가 발생했습니다.")
                    Console.WriteLine(ex.ToString())

                End Try
            End Using
        End Using
    End Sub
    Sub ExecuteNonQuery(conn As OracleConnection, sql As String, trans As OracleTransaction)
        Using cmd As New OracleCommand(sql, conn)
            cmd.Transaction = trans
            cmd.ExecuteNonQuery()
        End Using
    End Sub
End Module