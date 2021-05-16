package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Purchase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Tool.findAll", query = "select tl from Tool as tl")
})
@Table(name = "tool")
@Getter @Setter
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy="tools")
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "rented")
    private boolean rented;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return Objects.equals(id, tool.id) && Objects.equals(name, tool.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
