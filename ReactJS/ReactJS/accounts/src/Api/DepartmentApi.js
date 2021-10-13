import Api from "./Api";

const url = "/departments";
// Do chỉ cần lấy All Dep nên trong phần này chỉ viết phương thức getAll()
// Hàm get alll Department
const getAll = () => {
  return Api.get(url);
};

// export
const DepartmentApi = { getAll };
export default DepartmentApi;
