package com.ricky.services;

import com.ricky.model.Node;
import com.ricky.util.UpdateAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by caiqing on 16/10/20.
 */
@Service
@Slf4j
public class NodeService {

    public Node getNode(Integer id) {

        Node node = new Node();
        System.out.println("success get!!");
        return node;
    }

    public void addNode() {
        System.out.println("success add!!");
        return;
    }

    @UpdateAnnotation(key = "test")
    public void updateNode() {
        System.out.println("success update!!");
    }

}
