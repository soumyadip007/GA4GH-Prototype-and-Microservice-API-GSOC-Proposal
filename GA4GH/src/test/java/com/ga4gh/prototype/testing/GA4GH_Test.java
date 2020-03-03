package com.ga4gh.prototype.testing;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.restcontroller.AdminRestController;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class GA4GH_Test {

    private static final String SEQNAME = "Chr1";
    
    private static final String GENBANK = "GK000001.2";
    
    private static final String REFSEQ = "AC_000158.1";
    
    private static final String SEQUENCE_LENGTH = "15833706";
    
    @LocalServerPort
    int randomServerPort;
     
    @SuppressWarnings("deprecation")
	@Test
    public void testAll() throws URISyntaxException 
    {

        RestTemplate restTemplate = new RestTemplate();
         
        final String baseUrl = "http://localhost:8080/admin/add";
        URI uri = new URI(baseUrl);
     
        GA4GH g = new GA4GH("000", "000", "000", "000");
        
        HttpHeaders headers = new HttpHeaders();
     
        HttpEntity request = new HttpEntity(g, headers);
         
        try
        {
            restTemplate.postForEntity(uri, request, String.class);
           
        }
        catch(HttpClientErrorException ex) 
        {
        	
         }
    }
}
