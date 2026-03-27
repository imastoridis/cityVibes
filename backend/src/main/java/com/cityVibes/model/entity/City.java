

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country

    // --- Constructors ---
    public City() {
    }

    // --- Getters and setters ---
    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // City name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}