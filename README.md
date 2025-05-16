# Doctor-Patient Management API - Java Backend

## Overview

This project provides backend APIs for managing doctors and patients. It allows:
- Adding a doctor and their speciality
- Adding a patient and their symptoms
- Suggesting doctors based on patient's symptom and location

---

## Entities

### Doctor

Fields:
- name
- city (Delhi, Noida, Faridabad)
- email
- phone
- speciality (Orthopaedic, Gynecology, Dermatology, ENT)

### Patient

Fields:
- name
- city (any value)
- email
- phone
- symptom

Symptoms map:
- Orthopaedic: Arthritis, Back Pain, Tissue injuries
- Gynecology: Dysmenorrhea
- Dermatology: Skin infection, Skin burn
- ENT: Ear pain

---

## Validations

- Name: minimum 3 characters  
- City: max 20 characters  
- Email: must be valid  
- Phone: minimum 10 digits

---

## API Endpoints

### 1. Add Doctor

*POST* /api/doctors

*Request Body:*
```json
{
  "name": "Dr. Rahul Mehra",
  "city": "Noida",
  "email": "rahul.mehra@example.com",
  "phone": "9876543210",
  "speciality": "ENT"
}
{
  "id": 1,
  "message": "Doctor added successfully"
}

{
  "name": "Aarav Gupta",
  "city": "Noida",
  "email": "aarav.gupta@example.com",
  "phone": "9123456780",
  "symptom": "Ear pain"
}

{
  "id": 1,
  "message": "Patient added successfully"
}

[
  {
    "name": "Dr. Rahul Mehra",
    "city": "Noida",
    "speciality": "ENT",
    "email": "rahul.mehra@example.com"
  }
]
