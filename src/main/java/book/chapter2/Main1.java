/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter2;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.config.InMemoryXmlConfig;
import com.hazelcast.config.UrlXmlConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author denys
 */
public class Main1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        /*
        Looks for hazelcast.xml
        1. -Dhazelcast.config=<path to the hazelcast.xml>.
        2. Hazelcast checks if there is a hazelcast.xml in the working directory.
        3. Hazelcast checks if there is a hazelcast.xml on the classpath.
        4. loaded from the Hazelcast JAR.
        */
        
        //Read xml config programmatically
        //All these Config subclasses rely on the XmlConfigBuilder:
        //Config config = new XmlConfigBuilder().build();
        Config config1 = new ClasspathXmlConfig("hazelcast.xml");
        HazelcastInstance hz1 = Hazelcast.newHazelcastInstance(config1);
        
        Config config2 = new FileSystemXmlConfig("hazelcast.xml");
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(config2);
        
        String s = "<hazelcast>....</hazelcast>";
        Config config3 = new InMemoryXmlConfig(s);
        HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(config3);
        
        Config config4 = new UrlXmlConfig("http://foo/hazelcast.xml");
        HazelcastInstance hz4 = Hazelcast.newHazelcastInstance(config4);
        
        //programmatically config
        Config config5 = new Config();
        HazelcastInstance hz5 = Hazelcast.newHazelcastInstance(config5);


        //Logging programmatic config        
        Config cfg = new Config() ;
        cfg.setProperty("hazelcast.logging.type", "log4j");
        
        //Add properties programatic
        Properties properties = new Properties();
        properties.setProperty("pool.size","10");
        Config config6 = new XmlConfigBuilder().setProperties(properties).build();
        HazelcastInstance hz6 = Hazelcast.newHazelcastInstance(config6);        
        
        
    }

}
