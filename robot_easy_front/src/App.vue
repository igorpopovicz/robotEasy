<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <v-toolbar-title>Consulta de CEP</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container class="mt-10">
        <v-row justify="center">
          <v-col cols="12" md="6">
            <v-text-field v-model="cep" label="Digite o CEP" outlined clearable
              placeholder="Ex: 01001000"></v-text-field>
          </v-col>
        </v-row>
        <v-row justify="center">
          <v-col cols="12" md="6" mb="10">
            <v-btn @click="searchCep" color="primary" block large>Buscar</v-btn>
          </v-col>
        </v-row>

        <v-row justify="center" class="mt-13">
          <v-col cols="12" md="8">
            <v-card v-if="cepData" class="mx-auto">
              <v-card-title class="text-h6">Resultado da Consulta:</v-card-title>
              <v-card-text>
                <p><strong>Logradouro:</strong> {{ cepData.logradouro }}</p>
                <p><strong>Bairro:</strong> {{ cepData.bairro }}</p>
                <p><strong>Cidade:</strong> {{ cepData.localidade }}</p>
                <p><strong>UF:</strong> {{ cepData.uf }}</p>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>

    <v-footer app inset color="primary" dark>
      <v-col class="text-center white--text">&copy; 2024 Popovicz feito com ❤️ para a robotEasy</v-col>
    </v-footer>
  </v-app>
</template>

<script>
import axios from 'axios'
import { ref } from 'vue'

export default {
  setup() {
    const cep = ref('')
    const cepData = ref(null)

    const searchCep = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/cep/get?cep=${cep.value}`)
        cepData.value = response.data
      } catch (error) {
        console.error('Erro ao buscar CEP:', error)
      }
    }

    return { cep, cepData, searchCep }
  },
}
</script>

<style scoped>
.v-text-field {
  margin-bottom: 16px;
}

.v-card {
  padding: 20px;
}

.v-footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
