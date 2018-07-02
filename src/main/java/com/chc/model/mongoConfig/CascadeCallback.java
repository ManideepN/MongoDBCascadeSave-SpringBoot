package com.chc.model.mongoConfig;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

public class CascadeCallback implements ReflectionUtils.FieldCallback {

  private Object source;
  private MongoOperations mongoOperations;

  CascadeCallback(final Object source, final MongoOperations mongoOperations) {
    this.source = source;
    this.setMongoOperations(mongoOperations);
  }

  @Override
  public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
    ReflectionUtils.makeAccessible(field);
    System.out.println(" ****In doWith().");
    if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
      final Object fieldValue = field.get(getSource());

      if (fieldValue != null) {
        final FieldCallback callback = new FieldCallback();

        // Edit this block for handling other collections
        if (fieldValue instanceof List<?>) {
        	System.out.println(" ****Iterative save for List");
          for (Object object : (List<?>) fieldValue) {
            mongoOperations.save(object);
          }
        } else if (fieldValue instanceof Set<?>) {
          for (Object object : (Set<?>) fieldValue) {
            mongoOperations.save(object);
          }
        } else {
          ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
          getMongoOperations().save(fieldValue);
        }
      }
    }
  }

  private Object getSource() {
    return source;
  }
  

  public void setSource(Object source) {
	this.source = source;
}

private MongoOperations getMongoOperations() {
    return mongoOperations;
  }

  private void setMongoOperations(final MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

}
