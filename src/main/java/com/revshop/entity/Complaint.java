package com.revshop.entity;

public class Complaint {
    private int id;
    private int userId;
    private String message;

    public Complaint(int id, int userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    // Getters and setters

    public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
