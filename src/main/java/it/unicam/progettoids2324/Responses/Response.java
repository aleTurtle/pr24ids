package it.unicam.progettoids2324.Responses;

import org.springframework.http.ResponseEntity;

public class Response<T> {
    public String message;
    public T data;
    public Response (String message, T data){
        this.message=message;
        this.data=data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
