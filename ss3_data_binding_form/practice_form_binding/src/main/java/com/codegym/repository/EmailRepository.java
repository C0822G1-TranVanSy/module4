package com.codegym.repository;

import com.codegym.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository {
    private static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email(1,"English",10,true,"King, Asgard"));
        emailList.add(new Email(2,"Vietnamese",25,false,"Sy, Tran"));
        emailList.add(new Email(3,"Japanese",5,false,"Ki, Mochi"));
        emailList.add(new Email(4,"Chinese",15,true,"Ni, Hao"));}
    public List<Email> findAll(){
        return emailList;
    }

    public Email findById(int id){
        for (Email e: findAll()) {
            if(id==e.getId()){
                return e;
            }
        }
        return null;
    }

    public int findIndexById(int id){
        for (int i = 0; i <findAll().size() ; i++) {
            if(findAll().get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    public List<String> getLanguages(){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    public List<Integer> getPageSize(){
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }

    public void update(Email email, int id){
        findAll().set(findIndexById(id),email);
    }
}
