Problem Statement

1. The Problem

Many small to medium-sized clinics and hospitals still rely on manual registers or disjointed spreadsheets to track patient admissions and doctor schedules. This leads to:

Overbooking: Patients are admitted when no beds are available.

Scheduling Conflicts: Double-booking appointments for doctors.

Data Loss: Physical records are easily lost or damaged.

Inefficiency: Receptionists cannot quickly answer "Who is Dr. Smith seeing today?" or "Do we have a free bed?"

2. Scope of the Project

The "Hospital Bed & Appointment System" is a modular Java application intended to run on the hospital reception desk's computer. It digitizes the three core pillars of front-desk operations:

In-Patient Management: Handling admissions and bed capacity.

Resource Management: Maintaining a list of active doctors.

Out-Patient Management: Scheduling appointments.

It is designed as a standalone console application with local file storage, ensuring data privacy and offline capability.

3. Target Users

Receptionists / Front Desk Staff: The primary users who perform data entry and lookups.

Hospital Administrators: Users who view the analytics dashboard to make resource decisions (e.g., hiring more doctors if load is high).

4. High-Level Features

CRUD Operations: Create and Read operations for Patients and Doctors.

Business Logic Enforcement: System prevents admission if Bed Count > 20.

Relationship Mapping: Linking Appointments to specific Doctor IDs.

Persistence: Automatic saving/loading of data states.