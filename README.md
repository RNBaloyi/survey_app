# 📝 Survey App

A Spring Boot web application for collecting and analyzing survey data on people's lifestyle preferences.

## 📦 Tech Stack

- **Backend**:Java, Spring Boot, Spring Data JPA, Hibernate
- **Frontend**: Thymeleaf (HTML/CSS)
- **Database**: H2 in-memory database
- **Validation**: JSR 380 (Bean Validation)

## 🚀 Features

* 📋 **Fill Out Survey** with:

  * Full name, email, contact number, date of birth
  * Multiple-choice food preferences (Pizza, Pasta, Pap and Wors, Other)
  * Lifestyle ratings (movies, radio, eating out, TV) using a 1–5 scale

* 📊 **View Survey Results**:

  * ✅ Total number of surveys completed
  * 🎂 Average age
  * 👵 Oldest participant
  * 🧒 Youngest participant
  * 🍕 Percentage of users who like Pizza
  * 🍝 Percentage of users who like Pasta
  * 🍽️ Percentage of users who like Pap and Wors
  * 🎬 Average rating for **watching movies**
  * 📻 Average rating for **listening to radio**
  * 🍽️ Average rating for **eating out**
  * 📺 Average rating for **watching TV**

* ⚠️ **Validations**:

  * All text fields are required
  * Age must be between 5 and 120
  * All rating questions must be answered
  * Date picker used for birth date selection

## 🖥️ Run the App Locally

### ✅ Prerequisites

* Java 21+
* Maven

### 🔧 Steps to Run

1. **Clone the repository**

```bash
git clone https://github.com/RNBaloyi/survey_app.git
cd survey_app
```

2. **Run the app**

```bash
./mvnw spring-boot:run
```

Or with Java:

```bash
mvn clean install
java -jar target/survey_app-0.0.1-SNAPSHOT.jar
```

3. **Access in your browser**

* Survey form: [http://localhost:8081](http://localhost:8081)
* Results page: [http://localhost:8081/results](http://localhost:8081)
* H2 Console (dev only): [http://localhost:8081/h2-console](http://localhost:8081/h2-console)

  * **JDBC URL**: `jdbc:h2:mem:surveydb`
  * **Username**: `sa`
  * **Password**: *(leave blank)*


## 🎥 Deliverables

* A working web application
* Access to the project: [GitHub Repository](https://github.com/RNBaloyi/survey_app)
* Short video demonstration of the app in action

