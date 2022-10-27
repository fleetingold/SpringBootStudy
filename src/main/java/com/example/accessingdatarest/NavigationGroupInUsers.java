package com.example.accessingdatarest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Access_Navigationgroupinusers")
public class NavigationGroupInUsers {
    
	@Id
    private String id;

	@Column(name = "NavigationgroupID")
    private String navigationGroupId;

    @Column(name = "UserID")
    private String userId;

    @Column(name = "ApplicationID")
    private String applicationId;

	public void setId(String id) {
		this.id = id;
	}

    public String getId() {
		return id;
	}

	public void setNavigationGroupId(String navigationGroupId) {
		this.navigationGroupId = navigationGroupId;
	}

	public String getNavigationGroupId() {
		return navigationGroupId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getUserId() {
		return userId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationId() {
		return applicationId;
	}
}
