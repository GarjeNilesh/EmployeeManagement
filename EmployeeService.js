import axios from "axios";

const API_URL = "http://localhost:8080";

class EmployeeService {
    saveEmployee(employee) {
        return axios.post(`${API_URL}/saveEmployee`, employee);
    }
    
    saveWorker(worker) {
        return axios.post(`${API_URL}/saveWorker`, worker);
    }
    
    login(loginDetails) {
        return axios.post(`${API_URL}/login`, loginDetails);
    }

    getAllWorkers() {
        return axios.get(`${API_URL}/workers`);
    }

    deleteWorker(workerId) {
        return axios.delete(`${API_URL}/workers/${workerId}`);
    }
}

// Assign the instance to a variable
const employeeServiceInstance = new EmployeeService();

// Export the instance
export default employeeServiceInstance;
