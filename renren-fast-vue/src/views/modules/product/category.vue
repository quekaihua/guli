<template>
    <div>
        <el-tree :data="menus" :props="defaultProps" show-checkbox @node-click="handleNodeClick"
            :expand-on-click-node="false" node-key="catId" :default-expanded-keys="expandedKey">
            <span slot-scope="{node, data}">
                <span>{{ node.label }}</span>
                <span>
                    <el-button type="text" size="mini" v-if="node.level <= 2" @click="append(data)">Append</el-button>
                    <el-button v-if="node.childNodes.length == 0" type="text" size="mini"
                        @click="() => remove(node, data)">Delete</el-button>
                    <el-button type="text" size="mini" @click="() => edit(data)">Edit</el-button>
                </span>
            </span>
        </el-tree>
        <el-dialog title=":title" :visible.sync="dialogFormVisible">
            <el-form :model="category">
                <el-form-item label="分类名称">
                    <el-input v-model="category.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图标">
                    <el-input v-model="category.icon" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="计量单位">
                    <el-input v-model="category.productUnit" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitData()">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default {
    data() {
        return {
            menus: [],
            defaultProps: {
                children: "children",
                label: "name"
            },
            expandedKey: [],
            title: "",
            dialogType: "",
            dialogFormVisible: false,
            category: {
                name: "",
                parentCid: 0,
                catLevel: 0,
                showStatus: 1,
                sort: 0,
                productUnit: "",
                icon: "",
                catId: null,
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
                this.menus = data.data;
            });
        },
        append(data) {
            this.title = "添加分类";
            this.dialogType == "add"
            //显示对话框
            this.dialogFormVisible = true;
            //父id为当前点击数据id
            this.category.parentCid = data.catId;
            //显示层级为当前点击数据下一级
            this.category.catLevel = data.catLevel * 1 + 1;
            this.category.catId = null;
            this.category.name = "";
            this.category.icon = "";
            this.category.productUnit = "";
            this.category.sort = 0;
            this.category.showStatus = 1;
        },
        remove(node, data) {
            var ids = [data.catId];
            this.$confirm(`是否删除【${data.name}】菜单?`, "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            }).then(() => {
                this.$http({
                    url: this.$http.adornUrl('/product/category/delete'),
                    method: 'post',
                    data: this.$http.adornData(ids, false)
                }).then(({ data }) => {
                    this.$message({
                        message: "菜单删除成功",
                        type: "success",
                    });

                    this.getMenus();
                    this.expandedKey = [node.parent.data.catId];
                })
            })
        },
        edit(data) {
            this.title = "修改分类";
            this.dialogType == "edit";
            console.log(data)
            this.dialogFormVisible = true;
            this.$http({
                url: this.$http.adornUrl(`/product/category/info/${data.catId}`),
                method: "get"
            }).then(({ data }) => {
                this.category = data.category;
            })
        },
        submitData() {
            this.dialogType == "add" ? this.addCategory() : this.editCategory();
        },
        editCategory() {
            var { catId, name, icon, productUnit } = this.category;
            this.$http({
                url: this.$http.adornUrl("/product/category/update"),
                method: "post",
                data: this.$http.adornData({ catId, name, icon, productUnit }, false),
            }).then(({ data }) => {
                this.$message({
                    message: "菜单修改成功",
                    type: "success",
                });
                //关闭对话框
                this.dialogFormVisible = false;
                //刷新出新的菜单
                this.getMenus();
                //设置需要默认展开的菜单
                this.expandedKey = [this.category.parentCid];
            });
        },
        addCategory() {
            this.$http({
                url: this.$http.adornUrl('/product/category/save'),
                method: 'post',
                data: this.$http.adornData(this.category, false)
            }).then(({ data }) => {
                this.$message({
                    message: "菜单保存成功",
                    type: "success",
                });
                //关闭对话框
                this.dialogFormVisible = false;
                //刷新出新的菜单
                this.getMenus();
                //设置需要默认展开的菜单
                this.expandedKey = [this.category.parentCid];
            });
        }
    },

    created() {
        this.getMenus();
    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() { },
    beforeCreate() { }, //生命周期 - 创建之前
    beforeMount() { }, //生命周期 - 挂载之前
    beforeUpdate() { }, //生命周期 - 更新之前
    updated() { }, //生命周期 - 更新之后
    beforeDestroy() { }, //生命周期 - 销毁之前
    destroyed() { }, //生命周期 - 销毁完成
    activated() { } //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped></style>