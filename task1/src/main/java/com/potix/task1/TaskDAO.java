package com.potix.task1;

import java.util.*;
 
public interface TaskDAO {
public Task insert(Task t) throws Exception;
public Task update(Task t) throws Exception;
public void delete(Task t) throws Exception;
public Task findById(int id) throws Exception;
public List findAll() throws Exception;
public void call();
public void insertImage();
}
