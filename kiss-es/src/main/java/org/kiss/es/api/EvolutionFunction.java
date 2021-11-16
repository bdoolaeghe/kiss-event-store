package org.kiss.es.api;

import java.lang.annotation.*;

/**
 * Decorate an evolution function, changing the state of an entity
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EvolutionFunction {
}
