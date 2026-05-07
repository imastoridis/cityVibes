package com.cityVibes.feature.activity.entity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CultureActivity extends Activity {
    private String theme;
}
