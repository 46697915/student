
formData: {
id: '',
studId: '',
studCode: '',
studName: '',
courseId: '',
courseName: '',
teacherId: '',
teacherName: '',
teacher2Id: '',
teacher2Name: '',
teacher3Id: '',
teacher3Name: '',
courseBegin: '',
courseEnd: '',
llCourse: '',
jnCourse: '',
mbConut: '',
remark: ''
},

addUrl: this.domain.serverpath + "/studLearn/add"

    <el-table-column prop="id" label="字段" width="80" v-if="false"></el-table-column>
    <el-table-column prop="studId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studCode" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacherId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacherName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacher2Id" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacher2Name" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacher3Id" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacher3Name" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseBegin" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseEnd" label="字段" width="80" ></el-table-column>
    <el-table-column prop="llCourse" label="字段" width="80" ></el-table-column>
    <el-table-column prop="jnCourse" label="字段" width="80" ></el-table-column>
    <el-table-column prop="mbConut" label="字段" width="80" ></el-table-column>
    <el-table-column prop="remark" label="字段" width="80" ></el-table-column>

<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="id">
        <el-input v-model="formData.id"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="studId">
        <el-input v-model="formData.studId"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="studCode">
        <el-input v-model="formData.studCode"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="studName">
        <el-input v-model="formData.studName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="courseId">
        <el-input v-model="formData.courseId"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="courseName">
        <el-input v-model="formData.courseName"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="teacherId">
        <el-input v-model="formData.teacherId"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacherName">
        <el-input v-model="formData.teacherName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacher2Id">
        <el-input v-model="formData.teacher2Id"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="teacher2Name">
        <el-input v-model="formData.teacher2Name"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacher3Id">
        <el-input v-model="formData.teacher3Id"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacher3Name">
        <el-input v-model="formData.teacher3Name"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="courseBegin">
        <el-input v-model="formData.courseBegin"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="courseEnd">
        <el-input v-model="formData.courseEnd"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="llCourse">
        <el-input v-model="formData.llCourse"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="jnCourse">
        <el-input v-model="formData.jnCourse"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="mbConut">
        <el-input v-model="formData.mbConut"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="remark">
        <el-input v-model="formData.remark"></el-input>
        </el-form-item>
    </el-col>
</el-row>
