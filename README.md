# 🏛️ Alaska Legislature Senate Data Scraper (akleg-scraper)

This project is a Java-based web scraper designed to extract information about the current members of the Alaska Senate from the official legislative website.

---

## 🎯 Goal

* **Target URL:** https://akleg.gov/senate.php
* **Data Fields Extracted:** Name, Title, Position, Party, Address, Phone, Email, and the Senator's individual profile URL.
* **Output:** A JSON file named akleg_senate_jsoup.json.

---

## 💻 Technology Used

* **Language:** Java 17+
* **Build Tool:** Apache Maven 3.9.x
* **Scraping Library:** Jsoup (for fast, efficient parsing of static HTML)
* **JSON Serialization:** Jackson Databind

---

## 📂 Project Structure

The project follows a standard Maven structure:

akleg-scraper/
 ├─ pom.xml
 ├─ README.md
 ├─ akleg_senate_jsoup.json (Generated Output)
 └─ src/main/java/com/example/scraper/
     ├─ model/Person.java     (Data model class)
     ├─ Utils.java            (JSON writing utility)
     └─ ScraperJsoupAPI.java  (Main scraping logic)

---

## 🏃 Instructions to Run

These instructions assume you are running from the **Command Prompt (CMD)** within the project directory (C:\Users\Deepanshu\akleg-scraper>).

*Note: Since the Maven executable path was not added to the system's PATH environment variable, the full path to mvn.cmd must be used for execution.*

**1. Clean and Compile the Project (Build):**

```bash
"C:\Users\Deepanshu\anaconda3\apache-maven-3.9.11-bin\apache-maven-3.9.11\bin\mvn.cmd" clean compile
