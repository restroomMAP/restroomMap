import { useNavigate } from "react-router-dom";

export const AddRestroom = () => {
  const navigate = useNavigate();
  return (
    <div className="modalDiv">
      <div className="modal">
      <p style={{textAlign: "center", fontSize: 40}}>신규 정보 등록</p>
        <button onClick={() => navigate(-1)}>Close</button>
      </div>
    </div>
  );
};