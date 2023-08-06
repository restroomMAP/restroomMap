import { useNavigate } from "react-router-dom";

export const MyAccount = () => {
  const navigate = useNavigate();
  return (
    <div className="modalDiv">
      <div className="modal">
      <p style={{textAlign: "center", fontSize: 40}}>계정 관리</p>
        <button onClick={() => navigate(-1)}>Close</button>
      </div>
    </div>
  );
};