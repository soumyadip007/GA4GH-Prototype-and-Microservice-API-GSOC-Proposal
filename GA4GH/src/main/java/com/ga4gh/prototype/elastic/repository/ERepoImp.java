package com.ga4gh.prototype.elastic.repository;
//package com.ga4gh.prototype.repository;
//
//import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
//
//import java.util.List;
//
//import org.elasticsearch.index.query.QueryBuilders;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.stereotype.Repository;
//
//import com.ga4gh.prototype.entity.GA4GH;
//
//@Repository
//public class ERepoImp {
//
//	private final Logger LOG = LoggerFactory.getLogger(getClass());
//
//
//    @Autowired
//    private ElasticsearchTemplate esTemplate;
//
//    
//    public ERepoImp(ElasticsearchTemplate e)
//    {
//    	esTemplate=e;
//    }
//  
//    public List<GA4GH> getAllUsers() {
//        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
//                .withQuery(matchAllQuery()).build();
//        return esTemplate.queryForList(getAllQuery, GA4GH.class);
//    }
//    
//    
//    public List<GA4GH>  getUserById(String userId) {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withFilter(QueryBuilders.matchQuery("sequencename", userId)).build();
//        List<GA4GH> users = esTemplate.queryForList(searchQuery, GA4GH.class);
////        if(!users.isEmpty()) {
////            return users.get(0);
////        }
//        return users;
//    }
//}