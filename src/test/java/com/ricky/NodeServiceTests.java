package com.ricky;

import com.ricky.config.AppConfig;
import com.ricky.model.Node;
import com.ricky.services.NodeService;
import com.ricky.util.NodeAspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by caiqing on 16/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@Import(value= {NodeService.class, NodeAspect.class, Node.class})
@EnableAspectJAutoProxy
//@ActiveProfiles({ "test" })
public class NodeServiceTests {

    @Autowired
    NodeService nodeService;

    @Test
    public void testGetNode() {
        nodeService.getNode(1);
    }

//    @Test
    public void testAddNode() {
        nodeService.addNode();
    }

//    @Test
    public void testUpdateNode() {
        nodeService.updateNode();
    }
}
