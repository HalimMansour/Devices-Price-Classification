# Devices Price Classification System 

## Overview

The Devices Price Classification System is designed to predict and classify the prices of devices based on their specifications. This system consists of two main components:

- **Python Project**: Utilizes machine learning models to predict device prices.
- **Spring Boot Project**: Implements RESTful API endpoints to interact with the Python project for predictions and data storage.

## Python Project

### Dataset Information

- **Train Dataset**: [Link to Train Dataset](https://docs.google.com/spreadsheets/d/1C5K210JMYklz-_naYRaoxXPF6nZIGbXYrn0o0rBeY9I/edit?gid=1607079722#gid=1607079722)
- **Test Dataset**: [Link to Test Dataset](https://docs.google.com/spreadsheets/d/1ChyuXQFc7ivtDxdEnbII2lRT3xc6OaMSZp_ud7arf9U/edit?gid=2082460844#gid=2082460844)

#### Dataset Columns

- **id**: ID of the device
- **battery_power**: Total energy capacity of the battery in mAh
- **blue**: Bluetooth availability (0 or 1)
- **clock_speed**: Microprocessor speed in GHz
- **dual_sim**: Dual SIM support (0 or 1)
- **fc**: Front Camera megapixels
- **four_g**: 4G availability (0 or 1)
- **int_memory**: Internal Memory in GB
- **m_dep**: Mobile Depth in cm
- **mobile_wt**: Weight of the mobile phone
- **n_cores**: Number of processor cores
- **pc**: Primary Camera megapixels
- **px_height**: Pixel Resolution Height
- **px_width**: Pixel Resolution Width
- **ram**: RAM in MB
- **sc_h**: Screen Height in cm
- **sc_w**: Screen Width in cm
- **talk_time**: Battery talk time in hours
- **three_g**: 3G availability (0 or 1)
- **touch_screen**: Touchscreen availability (0 or 1)
- **wifi**: WiFi availability (0 or 1)
- **price_range**: Target variable with values indicating price categories (0 - low cost, 1 - medium cost, 2 - high cost, 3 - very high cost)

### Modeling Steps

1. **Data Preprocessing**:
   - Handle missing values.
   - Convert categorical variables to numerical.
   - Scale numerical features using StandardScaler.

2. **Exploratory Data Analysis (EDA)**:
   - Identify insights and correlations using visualizations.

3. **Model Selection and Training**:
   - Compare models such as Logistic Regression, Random Forest, SVM, and Gradient Boosting.
   - Evaluate each model using metrics like accuracy, confusion matrix, and classification report.

4. **Model Persistence**:
   - Save the trained model and scaler for deployment.

## Spring Boot 

### Endpoints

- **POST /api/devices/**: Retrieve a list of all devices.
- **GET /api/devices/{id}**: Retrieve details of a specific device by ID.
- **POST /api/devices/**: Add a new device.
- **POST /api/predict/{deviceId}**:
  - Calls Python API to predict the price based on device specs.
  - Saves the predicted price in the device entity.

### Implementation Details

- **DeviceController.java**: Defines REST endpoints to interact with devices and predict prices using the Python API.
- **DevicePriceClassificationApplication.java**: Main Spring Boot application class.
- **application.properties**: Configures application settings, including Python API URL.

## Testing

- Predict prices for 10 devices from the test dataset to validate model accuracy.


## Usage

### Prerequisites

- Python environment with required packages (`pandas`, `scikit-learn`, `matplotlib`, `seaborn`, `flask`, etc.).
- Java Development Kit (JDK) and Maven for Spring Boot application.

### Steps to Run

1. **Python Project**:
   - Clone the repository and navigate to the Python project directory.
   - Install dependencies: `pip install -r requirements.txt`.
   - Run `app.py` to start the Flask API.

2. **Spring Boot Project**:
   - Clone the repository and navigate to the Spring Boot project directory.
   - Build the project: `mvn clean install`.
   - Run the application: `mvn spring-boot:run`.

3. **Testing**:
   - Use Postman to send device specifications to `/api/predict/{deviceId}` endpoint.
   - Verify predictions returned by the API.

![Postman_hRzhemVrQB](https://github.com/user-attachments/assets/32d9e800-a228-4f2e-af4d-951579de2006)
