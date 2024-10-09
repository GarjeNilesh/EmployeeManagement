import { Navigate, Route, Routes } from 'react-router-dom';
import './App.css';
import { useAuth } from './AuthContext';
import AddWorker from './component/AddWorker';
import EditEmployee from './component/EditEmployee';
import Home from './component/Home';
import Login from './component/Login';
import Navbar from './component/Navbar';
import Register from './component/Register';

function ProtectedRoute({ children }) {
    const { isAuthenticated } = useAuth();
    return isAuthenticated ? children : <Navigate to="/Login" />;
}

function App() {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path='/Login' element={<Login />} />
                <Route path='/Register' element={<ProtectedRoute><Register /></ProtectedRoute>} />
                <Route path='/AddWorker' element={<ProtectedRoute><AddWorker /></ProtectedRoute>} />
                <Route path='/Home' element={<ProtectedRoute><Home /></ProtectedRoute>} />
                <Route path='/addEmployee' element={<ProtectedRoute><EditEmployee /></ProtectedRoute>} />
            </Routes>
        </>
    );
}

export default App;
