package com.ga4gh.prototype.testing;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class GA4GH_Test {

    private static final String SEQNAME = "Chr1";
    
    private static final String GENBANK = "GK000001.2";
    
    private static final String REFSEQ = "AC_000158.1";
    
    private static final String SEQUENCE_LENGTH = "15833706";
    
    @LocalServerPort
    int randomServerPort;
     
    @Test
    public void testGetEmployeeListSuccess() throws URISyntaxException 
    {
 
    }  
}
