import React from "react";
import { useState, useEffect } from "react";

function Hook3() {
  const [Count, setCount] = useState(0);
  // Trường hợp 1: thay thế cho componentdidmount, componentdidupdate
  // Mỗi khi click chuột thì giá trị Count tăng lên 1 đơn vị ==> State thay đổi, chương trình reRender lại ==> useEffect này được thực thi.
  useEffect(() => {
    console.log(
      "Sau khi reRender thì đoạn lệnh trong useEffect được thực thi."
    );
  });
  return (
    <div className="row">
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <button
          type="button"
          className="btn btn-success"
          onClick={() => setCount(Count + 1)}
        >
          Click
        </button>
      </div>
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <p style={{ fontSize: "50" }}>Bạn đã click {Count} lần.</p>
      </div>
    </div>
  );
}
export default Hook3;
