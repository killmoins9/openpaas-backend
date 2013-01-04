package com.linagora.openpaas.backend.dao;

import static org.fest.assertions.api.Assertions.assertThat;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;
import com.mongodb.Mongo;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;


public class TestMessageDaoEmbeddedMongo {

    private MongodExecutable mongodExe;
    private MongodProcess mongod;
    private Mongo mongo;
    
    
    @Before
    public void setUp() throws Exception {
        MongodStarter runtime = MongodStarter.getDefaultInstance();
        mongodExe = runtime.prepare(new MongodConfig(Version.Main.V2_0, 12345, Network.localhostIsIPv6()));
        mongod = mongodExe.start();
        mongo = new Mongo("localhost", 12345);
    }

    @After
    public void tearDown() throws Exception {
        mongod.stop();
        mongodExe.stop();
    }

    @Test
	public void testCreateMessage() throws UnknownHostException {
    	
    	MessageDAO dao = new MongoDbMessageDAO("localhost",12345);
		
		Message mesg = new Message();
		mesg.setBody("body of the message");
		mesg.setSubject("subject of the message");
		
		Message m = dao.create(mesg, null);
		Message m2 = dao.getMessage(m.getId(),null);
		assertThat(m).isEqualTo(m2);
	}
    
    
    @Test
	public void testFindUserMessage() throws UnknownHostException {
    	
    	MessageDAO dao = new MongoDbMessageDAO("localhost",12345);
    	
    	User toto = new User("totologin");
    	
		Message mesg = new Message();
		mesg.setBody("body of the message");
		mesg.setSubject("subject of the message");
		mesg.setUser(toto);
		Message m = dao.create(mesg, toto);
		
		List<Message> allmsg = dao.findAvailableMessage(toto);
		assertThat(allmsg).contains(m);
	}
    
	
}
