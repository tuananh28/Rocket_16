var storage = {

    setLocal(isLocalStorage) {
        localStorage.setItem("IS_LOCAL_STORAGE_CATEGORY", isLocalStorage);
    },

    isLocal() {
        var isLocalStorage = localStorage.getItem("IS_LOCAL_STORAGE_CATEGORY");

        if (isLocalStorage == null || isLocalStorage == undefined) {
            return true;
        }

        return JSON.parse(isLocalStorage.toLowerCase());
    },

    //localStorage.setItem("IS_LOCAL_STORAGE_CATEGORY", true);

    setItem(value, key) {
        if (this.isLocal()) {
            localStorage.setItem(value, key);
        } else {
            sessionStorage.setItem(value, key);
        }

    },

    getItem(key) {
        if (this.isLocal()) {
            return localStorage.getItem(key);
        } else {
            return sessionStorage.getItem(key);
        }
    },

    removeItem(key){
        if (this.isLocal()) {
            return localStorage.removeItem(key);
        } else {
            return sessionStorage.removeItem(key);
        }
    }
};