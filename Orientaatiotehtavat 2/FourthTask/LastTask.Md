# **Task 4: Three-Phase Simulation - Telephone Call Center Example**

## **Introduction:**

In this task, we are simulating a system for a telephone call center. The system consists of three main phases:

1. **Arrival Phase:** The client arrives at the call center.
2. **Service Phase:** The client receives service from an available agent.
3. **Departure Phase:** The client leaves the system after the service is completed.

The goal of the simulation is to track the events until one client of type "Y" exits the system.

---

## **Simulation Details:**

### 1. **Arrival Phase (Arrival):**
- The time at which the client arrives at the system is determined.
- After the client arrives, the system determines if the client will immediately start receiving service or if another client will arrive.

### 2. **Service Phase (Service):**
- The client begins receiving service from an available agent.
- After the service is completed, a departure event is triggered.

### 3. **Departure Phase (Departure):**
- Once the service is completed, the client leaves the system.
- The system needs to specifically track when a client of type "Y" leaves the system.
- The simulation stops when the first client of type "Y" exits.

---

## **Required Setup:**

### **Client Types:**
- Clients are of different types, such as Type A, Type B, and Type Y.
- The simulation specifically focuses on clients of type "Y". The simulation will stop when the first client of type "Y" exits the system.

### **Simulation Goal:**
- Track the processing of events continuously until the first client of type "Y" exits the system.
- Once the first client of type "Y" exits, the simulation terminates, and the process is considered complete.

---

## **Simulation Methodology:**

### **Phase 1 - Arrival:**
- When a new client arrives, it is determined whether they will begin receiving service immediately or if another client will be added to the queue.

### **Phase 2 - Service:**
- Once the client starts receiving service, the amount of time they will take for the service is determined.
- The service time can vary depending on the client type.

### **Phase 3 - Departure:**
- After the service is completed, the client leaves the system.
- If the client is of type "Y", the simulation stops immediately, and the task is considered finished.

---

## **Steps to Simulate:**

1. **Event Generation:**
    - For each client, an event is generated at their arrival time, and after that, an event is generated when they start the service and finally when they depart.

2. **Queue Management:**
    - Events are processed in a priority order based on the event time. The system processes the events in chronological order, with the earliest event being handled first.

3. **Client Departure:**
    - Track when the first client of type "Y" departs. Once this happens, the simulation ends.

4. **Termination Condition:**
    - The simulation will only stop when a client of type "Y" exits the system, ensuring the correct end condition is met.

---



---

### **Example Simulation Process:**

1. A client of type "A" arrives at the system.
2. They wait for an available agent and start the service.
3. After receiving service, they depart the system.
4. A client of type "B" arrives, and the process repeats.
5. Finally, a client of type "Y" arrives, and after receiving service, they depart, which triggers the end of the simulation.
