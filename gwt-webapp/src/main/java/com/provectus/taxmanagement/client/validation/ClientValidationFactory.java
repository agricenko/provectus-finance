package com.provectus.taxmanagement.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.google.gwt.validation.client.impl.Validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ClientValidationFactory extends AbstractGwtValidatorFactory {

    public static <T> Set<ConstraintViolation<T>> validate(T entity, Class<?>... groups) {
        return Validation.buildDefaultValidatorFactory().getValidator().validate(entity, groups);
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }

    @GwtValidation(value = {},
            groups = {})
    public interface GwtValidator extends Validator {
    }
}
