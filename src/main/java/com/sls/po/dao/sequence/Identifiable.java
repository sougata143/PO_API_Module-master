package com.sls.po.dao.sequence;

import java.io.Serializable;
public interface Identifiable<T extends Serializable> {

    T getId();
}
