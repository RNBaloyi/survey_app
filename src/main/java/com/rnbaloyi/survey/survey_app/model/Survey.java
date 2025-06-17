package com.rnbaloyi.survey.survey_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Contact number is required")
    private String contactNumber;

    // Favorite foods: multiple selection
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "survey_favorite_foods", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "favorite_food")
    private Set<String> favoriteFoods;

    // Ratings: 1 to 5, must not be null
    @NotNull(message = "Please rate 'I like to watch movies'")
    @Min(1) @Max(5)
    private Integer ratingMovies;

    @NotNull(message = "Please rate 'I like to listen to radio'")
    @Min(1) @Max(5)
    private Integer ratingRadio;

    @NotNull(message = "Please rate 'I like to eat out'")
    @Min(1) @Max(5)
    private Integer ratingEatOut;

    @NotNull(message = "Please rate 'I like to watch TV'")
    @Min(1) @Max(5)
    private Integer ratingWatchTV;

    public Survey() {}

    public int getAge() {
        if (dateOfBirth == null) return 0;
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public Integer getRatingMovies() {
        return ratingMovies;
    }

    public void setRatingMovies(Integer ratingMovies) {
        this.ratingMovies = ratingMovies;
    }

    public Integer getRatingRadio() {
        return ratingRadio;
    }

    public void setRatingRadio(Integer ratingRadio) {
        this.ratingRadio = ratingRadio;
    }

    public Integer getRatingEatOut() {
        return ratingEatOut;
    }

    public void setRatingEatOut(Integer ratingEatOut) {
        this.ratingEatOut = ratingEatOut;
    }

    public Integer getRatingWatchTV() {
        return ratingWatchTV;
    }

    public void setRatingWatchTV(Integer ratingWatchTV) {
        this.ratingWatchTV = ratingWatchTV;
    }
}
