import org.junit.Assert;
import org.junit.Test;
import com.program.JdbcProgram;
import com.program.MySqlConnectionExceptionHandle;

public class JdbcQueryTestCase {
@Test
public void jdbc_Program_QueryTestCase() throws MySqlConnectionExceptionHandle {
	JdbcProgram obj=new JdbcProgram();
	String query="update employee_payroll set salary=350000 where name='Terisa';";
	
	Assert.assertEquals(false, obj.ConnectionCreate(query));
}
}
