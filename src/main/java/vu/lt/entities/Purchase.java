package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Customer;
import vu.lt.entities.Tool;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Purchase.findAll", query = "select o from Purchase as o")
})
@Table(name = "purchase")
@Getter @Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "purchase")
    List<Tool> tools;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "purchase_time")
    @NotBlank
    private String purchaseTime;

    @Column(name = "deadline")
    @NotBlank
    private String deadline;

    @Column(name = "return_time")
    private String returnTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}