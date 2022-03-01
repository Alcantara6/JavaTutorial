package cn.itcast.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/2/27
 */
@Data
@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -4148807949961120856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    private String custName;

    private String custSource;

    private String custIndustry;

    private String custLevel;

    private String custAddress;

    private String custPhone;
}
