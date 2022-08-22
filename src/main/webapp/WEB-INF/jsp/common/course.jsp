<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 18/8/2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="course">
    <h2>{{ name }}</h2>
    <div class="curriculas">
        <div
                class="curricula"
                v-for="curricula in curriculas"
                v-bind:key="curricula.id"
                v-on:click="viewCurriculaDetails(curricula.id)"
        >
            <div class="header">
                <h2>{{curricula.curriculaId}} - {{ curricula.curriculaName }} </h2>
            </div>
            <div class="footer">
                <h3>{{ curricula.summary }}</h3>
            </div>
        </div>
    </div>
</div>
</template>

<script>
    export default {
        props: ['coursename', 'curriculas', 'courseID'],
        methods: {
            viewCurriculaDetails(curriculaID) {
                this.$router.push(`/curricula/${curriculaID}`);
            },
        }
    };
</script>


</style>
