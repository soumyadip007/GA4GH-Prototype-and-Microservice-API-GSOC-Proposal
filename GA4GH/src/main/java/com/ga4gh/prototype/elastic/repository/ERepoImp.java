package com.ga4gh.prototype.elastic.repository;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import com.ga4gh.prototype.entity.GA4GH;

@Repository("ERepoImp")
public class ERepoImp {

	//private final Logger LOG = LoggerFactory.getLogger(getClass());


    @Autowired
    private ElasticsearchTemplate esTemplate;

    
    public ERepoImp(ElasticsearchTemplate e)
    {
    	esTemplate=e;
    }
  
    public List<GA4GH> getAllUsers() {
    	
    	System.out.println("Debug");
    	System.out.println("Debug");
    	System.out.println("Debug");
    	System.out.println("Debug");
    	System.out.println("Debug");
    	
        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery()).build();
        return esTemplate.queryForList(getAllQuery, GA4GH.class);
    }
    
    
    public List<GA4GH>  getById(String userId) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.matchQuery("sequencename", userId)).build();
        List<GA4GH> users = esTemplate.queryForList(searchQuery, GA4GH.class);
//        if(!users.isEmpty()) {
//            return users.get(0);
//        }
        return users;
    }
    
    
    public List<GA4GH> getAllSequencename(String sequencename) {

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.matchQuery("sequencename", sequencename)).build();
        List<GA4GH> users = esTemplate.queryForList(searchQuery, GA4GH.class);
  
        return users;
    }
    
}