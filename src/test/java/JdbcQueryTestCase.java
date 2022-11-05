import org.junit.Assert;
import org.junit.Test;

import com.program.JdbcProgram;
import com.program.MySqlConnectionExceptionHandle;


public class JdbcQueryTestCase {
@Test
public void jdbc_Program_UpdateQueryTestCase() throws MySqlConnectionExceptionHandle {
	JdbcProgram obj=new JdbcProgram();	
	Assert.assertEquals(true, obj.ConnectionCreate("Terisa", 3000000));
}
}
