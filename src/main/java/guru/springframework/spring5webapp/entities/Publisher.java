package guru.springframework.spring5webapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String addressLine;
    private String country;
    private String city;
    private String postalAddress;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", books=" + books.stream().map(Book::toString).collect(Collectors.joining()) +
                '}';
    }
}
