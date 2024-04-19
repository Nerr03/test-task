import block_io_api.BlockAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseApiTest {
    BlockAPI blockAPI = new BlockAPI();

    @BeforeTest
    public void setUp(){

    }
}
