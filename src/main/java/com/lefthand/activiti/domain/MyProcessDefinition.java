package com.lefthand.activiti.domain;

import java.io.Serializable;

/**
 * Created by PanjinF on 2015/5/23.
 */
public class MyProcessDefinition implements Serializable {

    private String id;

    private String category;

    /**
     * label used for display purposes
     */
    private String name;

    /**
     * unique name for all versions this process definitions
     */
    private String key;

    /**
     * description of this process *
     */
    private String description;

    /**
     * version of this process definition
     */
    private int version;

    /**
     * name of {@link org.activiti.engine.RepositoryService#getResourceAsStream(String, String) the
     * resource} of this process definition.
     */
    private String resourceName;

    /**
     * The deployment in which this process definition is contained.
     */
    private String deploymentId;

    /**
     * The resource name in the deployment of the diagram image (if any).
     */
    private String diagramResourceName;

    public MyDeployment getDeployment() {
        return deployment;
    }

    public void setDeployment(MyDeployment deployment) {
        this.deployment = deployment;
    }

    public Integer isSuspension() {
        return suspension;
    }

    public void setSuspension(Integer suspension) {
        this.suspension = suspension;
    }

    private Integer suspension;

    private MyDeployment deployment;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
}
