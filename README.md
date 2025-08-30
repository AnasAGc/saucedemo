# 🚀 SauceDemo Automation Framework

## 📌 Overview
This project is an **Automation Testing Framework** built with:
- **Selenium WebDriver** (for UI tests)
- **RestAssured** (for API tests)
- **Cucumber (BDD with Gherkin)**
- **TestNG**
- **ExtentReports** (HTML & PDF reporting)

It covers:
- ✅ UI automation for [SauceDemo](https://www.saucedemo.com/)
- ✅ API automation for [Simple Books API](https://simple-books-api.click)

---

## 📂 Project Structure
└── test
├── java
│ ├── pageObject # Page Objects for UI
│ ├── resources # Base setup classes
│ ├── runners # Cucumber Runners
│ └── stepDefinitions # Cucumber Step Definitions (UI + API)
└── resources
├── features # Cucumber Feature files
└── extent.properties # Extent report configuration