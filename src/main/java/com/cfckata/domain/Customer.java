package com.cfckata.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Access;
import javax.persistence.AccessType;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2020/9/11 2:49 下午
 */
@Data
@Accessors(chain = true)
public class Customer {

    private String id;

    private String name;

    private String idnumber;

    private String mobilePhone;

}
