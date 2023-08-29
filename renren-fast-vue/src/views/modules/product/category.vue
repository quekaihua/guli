<template>
    <el-tree :data="menus" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
</template>

<script>
export default {
    data() {
        return {
            menus: [],
            defaultProps: {
                children: "childrens",
                label: "name"
            },
        }
    },
    methods: {
        handleNodeClick(data) {
            console.log(data);
        },
        getMenus() {
            this.dataListLoading = true;
            this.$http({
                url: this.$http.adornUrl("/product/category/list/tree"),
                method: "get"
            }).then(({ data }) => {
                console.log("获取到数据", data);
                this.menus = data;
            });
        }
    }
}
</script>
<style scoped></style>