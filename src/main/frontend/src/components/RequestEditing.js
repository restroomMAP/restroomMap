import { useNavigate } from "react-router-dom";

export const RequestEditing = () => {
  const navigate = useNavigate();
  return (
    <div className="modalDiv">
      <div className="modal">
      <p style={{textAlign: "center", fontSize: 40}}>정보 수정 요청</p>
        <button onClick={() => navigate(-1)}>Close</button>
      </div>
    </div>
  );
};