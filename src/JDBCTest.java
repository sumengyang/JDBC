/**
 * @author ��sumengyang
 * @date ��2016/07/06
 * @place��bupt
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
 
 
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        // MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
        // ������������Ҫָ��useUnicode��characterEncoding
        // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
        // �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
        String url = "jdbc:mysql://localhost:3306/jdbctest?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
 
        try {
            // ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
            // ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
            Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or��
            // new com.mysql.jdbc.Driver();
 
            System.out.println("�ɹ�����MySQL��������");
            // һ��Connection����һ�����ݿ�����
            conn = DriverManager.getConnection(url);
            // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
            Statement stmt = conn.createStatement();
            sql = "create table student17(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);// executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
            if (result != -1) {
                System.out.println("�������ݱ�ɹ�");
                sql = "insert into student17(NO,name) values('2012001','s1')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student17(NO,name) values('2012002','s2')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student17";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
                System.out.println("ѧ��\t����");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL��������");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
 
    }
 
}