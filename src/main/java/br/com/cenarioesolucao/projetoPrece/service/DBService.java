package br.com.cenarioesolucao.projetoPrece.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cenarioesolucao.projetoPrece.domain.Endereco;
import br.com.cenarioesolucao.projetoPrece.domain.Municipio;
import br.com.cenarioesolucao.projetoPrece.domain.UF;
import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.domain.enums.TipoUsuario;
import br.com.cenarioesolucao.projetoPrece.repository.EnderecoRepository;
import br.com.cenarioesolucao.projetoPrece.repository.MunicipioRepository;
import br.com.cenarioesolucao.projetoPrece.repository.UFRepository;
import br.com.cenarioesolucao.projetoPrece.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UFRepository ufRepository;
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private MunicipioService municipioService;
	
	
	
	public void instantiateTestDatabase() {
		
		/**
		 * Instanciando UF e Municipios
		 */
		UF uf1 = new UF(null, "Acre", "AC");
		UF uf2 = new UF(null, "Alagoas", "AL");
		UF uf3 = new UF(null, "Amazonas", "AM");
		UF uf4 = new UF(null, "Amapá", "AP");
		UF uf5 = new UF(null, "Bahia", "BA");
		UF uf6 = new UF(null, "Ceará", "CE");
		UF uf7 = new UF(null, "Distrito Federal", "DF");
		UF uf8 = new UF(null, "Espírito Santo", "ES");
		UF uf9 = new UF(null, "Goiás", "GO");
		UF uf10 = new UF(null, "Maranhão", "MA");
		UF uf11 = new UF(null, "Minas Gerais", "MG");
		UF uf12 = new UF(null, "Mato Grosso do Sul", "MS");
		UF uf13 = new UF(null, "Mato Grosso", "MT");
		UF uf14 = new UF(null, "Pará", "PA");
		UF uf15 = new UF(null, "Paraíba", "PB");
		UF uf16 = new UF(null, "Pernambuco", "PE");
		UF uf17 = new UF(null, "Piauí", "PI");
		UF uf18 = new UF(null, "Paraná", "PR");
		UF uf19 = new UF(null, "Rio de Janeiro", "RJ");
		UF uf20 = new UF(null, "Rio Grande do Norte", "RN");
		UF uf21 = new UF(null, "Rondônia", "RO");
		UF uf22 = new UF(null, "Roraima", "RR");
		UF uf23 = new UF(null, "Rio Grande do Sul", "RS");
		UF uf24 = new UF(null, "Santa Catarina", "SC");
		UF uf25 = new UF(null, "Sergipe", "SE");
		UF uf26 = new UF(null, "São Paulo", "SP");
		UF uf27 = new UF(null, "Tocantins", "TO");
		
		ufRepository.saveAll(Arrays.asList(uf1, uf2, uf3, uf4, uf5, uf6, uf7, 
				uf8, uf9, uf10, uf11, uf12, uf13, uf14, uf15, uf16, uf17, uf18, 
				uf19, uf20, uf21, uf22, uf23, uf24, uf25, uf26, uf27));
		
		
		instanciaMunUf1(uf1);
		instanciaMunUf2(uf2);
		instanciaMunUf3(uf3);
		instanciaMunUf4(uf4);
		instanciaMunUf5(uf5);
		instanciaMunUf6(uf6);
		instanciaMunUf7(uf7);
		instanciaMunUf8(uf8);
		instanciaMunUf9(uf9);
		instanciaMunUf10(uf10);
		
		instanciaMunUf11(uf11);
		instanciaMunUf12(uf12);
		instanciaMunUf13(uf13);
		instanciaMunUf14(uf14);
		instanciaMunUf15(uf15);
		instanciaMunUf16(uf16);
		instanciaMunUf17(uf17);
		instanciaMunUf18(uf18);
		instanciaMunUf19(uf19);
		instanciaMunUf20(uf20);
		
		instanciaMunUf21(uf21);
		instanciaMunUf22(uf22);
		instanciaMunUf23(uf23);
		instanciaMunUf24(uf24);
		instanciaMunUf25(uf25);
		instanciaMunUf26(uf26);
		instanciaMunUf27(uf27);
		
		/**
		 * Instanciando Usuario, telefone e endereco
		 */
		Usuario usuario01 = new Usuario(null, "Gláucio Júnior Teixeira", "glaucio.teixeira@outlook.com", "87853310668", TipoUsuario.PESSOAFISICA, passwordEncoder.encode("123"));
		usuario01.getTelefones().addAll(Arrays.asList("31999500593", "31999100593"));
		
		
		Municipio mun591 = municipioService.buscarId(2128);
		
		Endereco endereco01 = new Endereco(null, "Rua Geraldo Ramos", "170", "Casa", "Novo Santa Cecília", "30626692", usuario01, mun591);
		Endereco endereco02 = new Endereco(null, "Rua Geraldo Ramos", "135", "Casa", "Novo Santa Cecília", "30626692", usuario01, mun591);
		
		usuario01.getEnderecos().addAll(Arrays.asList(endereco01, endereco02));
		
		usuarioRepository.saveAll(Arrays.asList(usuario01));
		enderecoRepository.saveAll(Arrays.asList(endereco01, endereco02));
		
	}
	
	private void instanciaMunUf1(UF uf1) {
		Municipio mun28 = new Municipio(null, "Acrelândia", uf1);
		Municipio mun410 = new Municipio(null, "Assis Brasil", uf1);
		Municipio mun752 = new Municipio(null, "Brasiléia", uf1);
		Municipio mun795 = new Municipio(null, "Bujari", uf1);
		Municipio mun1082 = new Municipio(null, "Capixaba", uf1);
		Municipio mun1482 = new Municipio(null, "Cruzeiro do Sul", uf1);
		Municipio mun1679 = new Municipio(null, "Epitaciolândia", uf1);
		Municipio mun1757 = new Municipio(null, "Feijó", uf1);
		Municipio mun2608 = new Municipio(null, "Jordão", uf1);
		Municipio mun2886 = new Municipio(null, "Mâncio Lima", uf1);
		Municipio mun2900 = new Municipio(null, "Manoel Urbano", uf1);
		Municipio mun2946 = new Municipio(null, "Marechal Thaumaturgo", uf1);
		Municipio mun3868 = new Municipio(null, "Plácido de Castro", uf1);
		Municipio mun3940 = new Municipio(null, "Porto Acre", uf1);
		Municipio mun3974 = new Municipio(null, "Porto Walter", uf1);
		Municipio mun4190 = new Municipio(null, "Rio Branco", uf1);
		Municipio mun4257 = new Municipio(null, "Rodrigues Alves", uf1);
		Municipio mun4468 = new Municipio(null, "Santa Rosa do Purus", uf1);
		Municipio mun4958 = new Municipio(null, "Sena Madureira", uf1);
		Municipio mun4966 = new Municipio(null, "Senador Guiomard", uf1);
		Municipio mun5172 = new Municipio(null, "Tarauacá", uf1);
		Municipio mun5555 = new Municipio(null, "Xapuri", uf1);
		
		municipioRepository.saveAll(Arrays.asList(mun28, mun410, mun752, mun795, mun1082, mun1482, 
				mun1679, mun1757, mun2608, mun2886, mun2900, mun2946, mun3868, mun3940, mun3974, 
				mun4190, mun4257, mun4468, mun4958, mun4966, mun5172, mun5555));
	}
	
	private void instanciaMunUf2(UF uf2) {
		Municipio mun51 = new Municipio(null, "Água Branca", uf2);
		Municipio mun211 = new Municipio(null, "Anadia", uf2);
		Municipio mun331 = new Municipio(null, "Arapiraca", uf2);
		Municipio mun419 = new Municipio(null, "Atalaia", uf2);
		Municipio mun511 = new Municipio(null, "Barra de Santo Antônio", uf2);
		Municipio mun514 = new Municipio(null, "Barra de São Miguel", uf2);
		Municipio mun562 = new Municipio(null, "Batalha", uf2);
		Municipio mun585 = new Municipio(null, "Belém", uf2);
		Municipio mun593 = new Municipio(null, "Belo Monte", uf2);
		Municipio mun652 = new Municipio(null, "Boca da Mata", uf2);
		Municipio mun745 = new Municipio(null, "Branquinha", uf2);
		Municipio mun860 = new Municipio(null, "Cacimbinhas", uf2);
		Municipio mun899 = new Municipio(null, "Cajueiro", uf2);
		Municipio mun940 = new Municipio(null, "Campestre", uf2);
		Municipio mun957 = new Municipio(null, "Campo Alegre", uf2);
		Municipio mun973 = new Municipio(null, "Campo Grande", uf2);
		Municipio mun1004 = new Municipio(null, "Canapi", uf2);
		Municipio mun1060 = new Municipio(null, "Capela", uf2);
		Municipio mun1144 = new Municipio(null, "Carneiros", uf2);
		Municipio mun1241 = new Municipio(null, "Chã Preta", uf2);
		Municipio mun1298 = new Municipio(null, "Coité do Nóia", uf2);
		Municipio mun1314 = new Municipio(null, "Colônia Leopoldina", uf2);
		Municipio mun1375 = new Municipio(null, "Coqueiro Seco", uf2);
		Municipio mun1430 = new Municipio(null, "Coruripe", uf2);
		Municipio mun1444 = new Municipio(null, "Craíbas", uf2);
		Municipio mun1538 = new Municipio(null, "Delmiro Gouveia", uf2);
		Municipio mun1588 = new Municipio(null, "Dois Riachos", uf2);
		Municipio mun1719 = new Municipio(null, "Estrela de Alagoas", uf2);
		Municipio mun1760 = new Municipio(null, "Feira Grande", uf2);
		Municipio mun1768 = new Municipio(null, "Feliz Deserto", uf2);
		Municipio mun1793 = new Municipio(null, "Flexeiras", uf2);
		Municipio mun1910 = new Municipio(null, "Girau do Ponciano", uf2);
		Municipio mun2085 = new Municipio(null, "Ibateguara", uf2);
		Municipio mun2139 = new Municipio(null, "Igaci", uf2);
		Municipio mun2153 = new Municipio(null, "Igreja Nova", uf2);
		Municipio mun2209 = new Municipio(null, "Inhapi", uf2);
		Municipio mun2473 = new Municipio(null, "Jacaré dos Homens", uf2);
		Municipio mun2484 = new Municipio(null, "Jacuípe", uf2);
		Municipio mun2522 = new Municipio(null, "Japaratinga", uf2);
		Municipio mun2537 = new Municipio(null, "Jaramataia", uf2);
		Municipio mun2567 = new Municipio(null, "Jequiá da Praia", uf2);
		Municipio mun2600 = new Municipio(null, "Joaquim Gomes", uf2);
		Municipio mun2638 = new Municipio(null, "Jundiá", uf2);
		Municipio mun2642 = new Municipio(null, "Junqueiro", uf2);
		Municipio mun2683 = new Municipio(null, "Lagoa da Canoa", uf2);
		Municipio mun2776 = new Municipio(null, "Limoeiro de Anadia", uf2);
		Municipio mun2839 = new Municipio(null, "Maceió", uf2);
		Municipio mun2866 = new Municipio(null, "Major Isidoro", uf2);
		Municipio mun2908 = new Municipio(null, "Mar Vermelho", uf2);
		Municipio mun2920 = new Municipio(null, "Maragogi", uf2);
		Municipio mun2932 = new Municipio(null, "Maravilha", uf2);
		Municipio mun2944 = new Municipio(null, "Marechal Deodoro", uf2);
		Municipio mun2957 = new Municipio(null, "Maribondo", uf2);
		Municipio mun2992 = new Municipio(null, "Mata Grande", uf2);
		Municipio mun3022 = new Municipio(null, "Matriz de Camaragibe", uf2);
		Municipio mun3053 = new Municipio(null, "Messias", uf2);
		Municipio mun3067 = new Municipio(null, "Minador do Negrão", uf2);
		Municipio mun3161 = new Municipio(null, "Monteirópolis", uf2);
		Municipio mun3224 = new Municipio(null, "Murici", uf2);
		Municipio mun3407 = new Municipio(null, "Novo Lino", uf2);
		Municipio mun3433 = new Municipio(null, "Olho d'Água das Flores", uf2);
		Municipio mun3434 = new Municipio(null, "Olho d'Água do Casado", uf2);
		Municipio mun3436 = new Municipio(null, "Olho d'Água Grande", uf2);
		Municipio mun3450 = new Municipio(null, "Olivença", uf2);
		Municipio mun3477 = new Municipio(null, "Ouro Branco", uf2);
		Municipio mun3517 = new Municipio(null, "Palestina", uf2);
		Municipio mun3533 = new Municipio(null, "Palmeira dos Índios", uf2);
		Municipio mun3558 = new Municipio(null, "Pão de Açúcar", uf2);
		Municipio mun3610 = new Municipio(null, "Pariconha", uf2);
		Municipio mun3613 = new Municipio(null, "Paripueira", uf2);
		Municipio mun3633 = new Municipio(null, "Passo de Camaragibe", uf2);
		Municipio mun3672 = new Municipio(null, "Paulo Jacinto", uf2);
		Municipio mun3733 = new Municipio(null, "Penedo", uf2);
		Municipio mun3761 = new Municipio(null, "Piaçabuçu", uf2);
		Municipio mun3781 = new Municipio(null, "Pilar", uf2);
		Municipio mun3792 = new Municipio(null, "Pindoba", uf2);
		Municipio mun3837 = new Municipio(null, "Piranhas", uf2);
		Municipio mun3887 = new Municipio(null, "Poço das Trincheiras", uf2);
		Municipio mun3948 = new Municipio(null, "Porto Calvo", uf2);
		Municipio mun3951 = new Municipio(null, "Porto de Pedras", uf2);
		Municipio mun3965 = new Municipio(null, "Porto Real do Colégio", uf2);
		Municipio mun4063 = new Municipio(null, "Quebrangulo", uf2);
		Municipio mun4221 = new Municipio(null, "Rio Largo", uf2);
		Municipio mun4281 = new Municipio(null, "Roteiro", uf2);
		Municipio mun4416 = new Municipio(null, "Santa Luzia do Norte", uf2);
		Municipio mun4502 = new Municipio(null, "Santana do Ipanema", uf2);
		Municipio mun4509 = new Municipio(null, "Santana do Mundaú", uf2);
		Municipio mun4598 = new Municipio(null, "São Brás", uf2);
		Municipio mun4743 = new Municipio(null, "São José da Laje", uf2);
		Municipio mun4746 = new Municipio(null, "São José da Tapera", uf2);
		Municipio mun4811 = new Municipio(null, "São Luís do Quitunde", uf2);
		Municipio mun4845 = new Municipio(null, "São Miguel dos Campos", uf2);
		Municipio mun4846 = new Municipio(null, "São Miguel dos Milagres", uf2);
		Municipio mun4901 = new Municipio(null, "São Sebastião", uf2);
		Municipio mun4939 = new Municipio(null, "Satuba", uf2);
		Municipio mun4972 = new Municipio(null, "Senador Rui Palmeira", uf2);
		Municipio mun5140 = new Municipio(null, "Tanque d'Arca", uf2);
		Municipio mun5163 = new Municipio(null, "Taquarana", uf2);
		Municipio mun5202 = new Municipio(null, "Teotônio Vilela", uf2);
		Municipio mun5265 = new Municipio(null, "Traipu", uf2);
		Municipio mun5377 = new Municipio(null, "União dos Palmares", uf2);
		Municipio mun5490 = new Municipio(null, "Viçosa", uf2);

		municipioRepository.saveAll(Arrays.asList(mun1004, mun1060, mun1144, mun1241, mun1298, mun1314, mun1375, mun1430, 
			mun1444, mun1538, mun1588, mun1719, mun1760, mun1768, mun1793, mun1910, 
			mun2085, mun2139, mun2153, mun2209, mun2473, mun2484, mun2522, mun2537, 
			mun2567, mun2600, mun2638, mun2642, mun2683, mun2776, mun2839, mun2866, 
			mun2908, mun2920, mun2932, mun2944, mun2957, mun2992, mun3022, mun3053, 
			mun3067, mun3161, mun3224, mun3407, mun3433, mun3434, mun3436, mun3450, 
			mun3477, mun3517, mun3533, mun3558, mun3610, mun3613, mun3633, mun3672, 
			mun3733, mun3761, mun3781, mun3792, mun3837, mun3887, mun3948, mun3951, 
			mun3965, mun4063, mun4221, mun4281, mun4416, mun4502, mun4509, mun4598, 
			mun4743, mun4746, mun4811, mun4845, mun4846, mun4901, mun4939, mun4972, 
			mun51, mun211, mun331, mun419, mun511, mun514, mun562, mun585, 
			mun5140, mun5163, mun5202, mun5265, mun5377, mun5490, 
			mun593, mun652, mun745, mun860, mun899, mun940, mun957, mun973));

		
	}
	
	private void instanciaMunUf3(UF uf3) {
		Municipio mun171 = new Municipio(null, "Alvarães", uf3);
		Municipio mun196 = new Municipio(null, "Amaturá", uf3);
		Municipio mun217 = new Municipio(null, "Anamã", uf3);
		Municipio mun253 = new Municipio(null, "Anori", uf3);
		Municipio mun287 = new Municipio(null, "Apuí", uf3);
		Municipio mun417 = new Municipio(null, "Atalaia do Norte", uf3);
		Municipio mun437 = new Municipio(null, "Autazes", uf3);
		Municipio mun502 = new Municipio(null, "Barcelos", uf3);
		Municipio mun542 = new Municipio(null, "Barreirinha", uf3);
		Municipio mun602 = new Municipio(null, "Benjamin Constant", uf3);
		Municipio mun616 = new Municipio(null, "Beruri", uf3);
		Municipio mun647 = new Municipio(null, "Boa Vista do Ramos", uf3);
		Municipio mun653 = new Municipio(null, "Boca do Acre", uf3);
		Municipio mun726 = new Municipio(null, "Borba", uf3);
		Municipio mun815 = new Municipio(null, "Caapiranga", uf3);
		Municipio mun1046 = new Municipio(null, "Canutama", uf3);
		Municipio mun1099 = new Municipio(null, "Carauari", uf3);
		Municipio mun1110 = new Municipio(null, "Careiro da Várzea", uf3);
		Municipio mun1111 = new Municipio(null, "Careiro", uf3);
		Municipio mun1286 = new Municipio(null, "Coari", uf3);
		Municipio mun1294 = new Municipio(null, "Codajás", uf3);
		Municipio mun1644 = new Municipio(null, "Eirunepé", uf3);
		Municipio mun1678 = new Municipio(null, "Envira", uf3);
		Municipio mun1817 = new Municipio(null, "Fonte Boa", uf3);
		Municipio mun1985 = new Municipio(null, "Guajará", uf3);
		Municipio mun2072 = new Municipio(null, "Humaitá", uf3);
		Municipio mun2241 = new Municipio(null, "Ipixuna", uf3);
		Municipio mun2266 = new Municipio(null, "Iranduba", uf3);
		Municipio mun2301 = new Municipio(null, "Itacoatiara", uf3);
		Municipio mun2338 = new Municipio(null, "Itamarati", uf3);
		Municipio mun2381 = new Municipio(null, "Itapiranga", uf3);
		Municipio mun2531 = new Municipio(null, "Japurá", uf3);
		Municipio mun2654 = new Municipio(null, "Juruá", uf3);
		Municipio mun2664 = new Municipio(null, "Jutaí", uf3);
		Municipio mun2668 = new Municipio(null, "Lábrea", uf3);
		Municipio mun2881 = new Municipio(null, "Manacapuru", uf3);
		Municipio mun2883 = new Municipio(null, "Manaquiri", uf3);
		Municipio mun2885 = new Municipio(null, "Manaus", uf3);
		Municipio mun2897 = new Municipio(null, "Manicoré", uf3);
		Municipio mun2910 = new Municipio(null, "Maraã", uf3);
		Municipio mun3028 = new Municipio(null, "Maués", uf3);
		Municipio mun3259 = new Municipio(null, "Nhamundá", uf3);
		Municipio mun3351 = new Municipio(null, "Nova Olinda do Norte", uf3);
		Municipio mun3390 = new Municipio(null, "Novo Airão", uf3);
		Municipio mun3392 = new Municipio(null, "Novo Aripuanã", uf3);
		Municipio mun3611 = new Municipio(null, "Parintins", uf3);
		Municipio mun3657 = new Municipio(null, "Pauini", uf3);
		Municipio mun4014 = new Municipio(null, "Presidente Figueiredo", uf3);
		Municipio mun4234 = new Municipio(null, "Rio Preto da Eva", uf3);
		Municipio mun4405 = new Municipio(null, "Santa Isabel do Rio Negro", uf3);
		Municipio mun4550 = new Municipio(null, "Santo Antônio do Içá", uf3);
		Municipio mun4655 = new Municipio(null, "São Gabriel da Cachoeira", uf3);
		Municipio mun4851 = new Municipio(null, "São Paulo de Olivença", uf3);
		Municipio mun4899 = new Municipio(null, "São Sebastião do Uatumã", uf3);
		Municipio mun5048 = new Municipio(null, "Silves", uf3);
		Municipio mun5107 = new Municipio(null, "Tabatinga", uf3);
		Municipio mun5145 = new Municipio(null, "Tapauá", uf3);
		Municipio mun5183 = new Municipio(null, "Tefé", uf3);
		Municipio mun5254 = new Municipio(null, "Tonantins", uf3);
		Municipio mun5340 = new Municipio(null, "Uarini", uf3);
		Municipio mun5395 = new Municipio(null, "Urucará", uf3);
		Municipio mun5399 = new Municipio(null, "Urucurituba", uf3);

		municipioRepository.saveAll(Arrays.asList(mun1099, mun1110, mun1111, mun1286, mun1294, mun1644, mun1678, mun1817, 
			mun171, mun196, mun217, mun253, mun287, mun417, mun437, mun502, 
			mun1985, mun2072, mun2241, mun2266, mun2301, mun2338, mun2381, mun2531, 
			mun2654, mun2664, mun2668, mun2881, mun2883, mun2885, mun2897, mun2910, 
			mun3028, mun3259, mun3351, mun3390, mun3392, mun3611, mun3657, mun4014, 
			mun4234, mun4405, mun4550, mun4655, mun4851, mun4899, mun5048, mun5107, 
			mun5145, mun5183, mun5254, mun5340, mun5395, mun5399, 
			mun542, mun602, mun616, mun647, mun653, mun726, mun815, mun1046));

	}
	
	private void instanciaMunUf4(UF uf4) {
		Municipio mun188 = new Municipio(null, "Amapá", uf4);
		Municipio mun903 = new Municipio(null, "Calçoene", uf4);
		Municipio mun1526 = new Municipio(null, "Cutias", uf4);
		Municipio mun1781 = new Municipio(null, "Ferreira Gomes", uf4);
		Municipio mun2424 = new Municipio(null, "Itaubal", uf4);
		Municipio mun2741 = new Municipio(null, "Laranjal do Jari", uf4);
		Municipio mun2831 = new Municipio(null, "Macapá", uf4);
		Municipio mun3034 = new Municipio(null, "Mazagão", uf4);
		Municipio mun3429 = new Municipio(null, "Oiapoque", uf4);
		Municipio mun3685 = new Municipio(null, "Pedra Branca do Amaparí", uf4);
		Municipio mun3960 = new Municipio(null, "Porto Grande", uf4);
		Municipio mun3990 = new Municipio(null, "Pracuúba", uf4);
		Municipio mun4517 = new Municipio(null, "Santana", uf4);
		Municipio mun4997 = new Municipio(null, "Serra do Navio", uf4);
		Municipio mun5174 = new Municipio(null, "Tartarugalzinho", uf4);
		Municipio mun5532 = new Municipio(null, "Vitória do Jari", uf4);

		municipioRepository.saveAll(Arrays.asList(mun188, mun903, mun1526, mun1781, mun2424, mun2741, mun2831, mun3034, 
				mun3429, mun3685, mun3960, mun3990, mun4517, mun4997, mun5174, mun5532));

	}
	
	private void instanciaMunUf5(UF uf5) {
		Municipio mun8 = new Municipio(null, "Abaíra", uf5);
		Municipio mun9 = new Municipio(null, "Abaré", uf5);
		Municipio mun19 = new Municipio(null, "Acajutiba", uf5);
		Municipio mun36 = new Municipio(null, "Adustina", uf5);
		Municipio mun58 = new Municipio(null, "Água Fria", uf5);
		Municipio mun83 = new Municipio(null, "Aiquara", uf5);
		Municipio mun93 = new Municipio(null, "Alagoinhas", uf5);
		Municipio mun100 = new Municipio(null, "Alcobaça", uf5);
		Municipio mun120 = new Municipio(null, "Almadina", uf5);
		Municipio mun195 = new Municipio(null, "Amargosa", uf5);
		Municipio mun197 = new Municipio(null, "Amélia Rodrigues", uf5);
		Municipio mun198 = new Municipio(null, "América Dourada", uf5);
		Municipio mun212 = new Municipio(null, "Anagé", uf5);
		Municipio mun227 = new Municipio(null, "Andaraí", uf5);
		Municipio mun229 = new Municipio(null, "Andorinha", uf5);
		Municipio mun240 = new Municipio(null, "Angical", uf5);
		Municipio mun244 = new Municipio(null, "Anguera", uf5);
		Municipio mun255 = new Municipio(null, "Antas", uf5);
		Municipio mun259 = new Municipio(null, "Antônio Cardoso", uf5);
		Municipio mun263 = new Municipio(null, "Antônio Gonçalves", uf5);
		Municipio mun283 = new Municipio(null, "Aporá", uf5);
		Municipio mun285 = new Municipio(null, "Apuarema", uf5);
		Municipio mun297 = new Municipio(null, "Araças", uf5);
		Municipio mun299 = new Municipio(null, "Aracatu", uf5);
		Municipio mun301 = new Municipio(null, "Araci", uf5);
		Municipio mun324 = new Municipio(null, "Aramari", uf5);
		Municipio mun353 = new Municipio(null, "Arataca", uf5);
		Municipio mun356 = new Municipio(null, "Aratuípe", uf5);
		Municipio mun430 = new Municipio(null, "Aurelino Leal", uf5);
		Municipio mun457 = new Municipio(null, "Baianópolis", uf5);
		Municipio mun460 = new Municipio(null, "Baixa Grande", uf5);
		Municipio mun485 = new Municipio(null, "Banzaê", uf5);
		Municipio mun507 = new Municipio(null, "Barra da Estiva", uf5);
		Municipio mun517 = new Municipio(null, "Barra do Choça", uf5);
		Municipio mun522 = new Municipio(null, "Barra do Mendes", uf5);
		Municipio mun528 = new Municipio(null, "Barra do Rocha", uf5);
		Municipio mun535 = new Municipio(null, "Barra", uf5);
		Municipio mun541 = new Municipio(null, "Barreiras", uf5);
		Municipio mun547 = new Municipio(null, "Barro Alto", uf5);
		Municipio mun550 = new Municipio(null, "Barro Preto (antigo Gov. Lomanto Jr.)", uf5);
		Municipio mun552 = new Municipio(null, "Barrocas", uf5);
		Municipio mun589 = new Municipio(null, "Belmonte", uf5);
		Municipio mun590 = new Municipio(null, "Belo Campo", uf5);
		Municipio mun628 = new Municipio(null, "Biritinga", uf5);
		Municipio mun637 = new Municipio(null, "Boa Nova", uf5);
		Municipio mun649 = new Municipio(null, "Boa Vista do Tupim", uf5);
		Municipio mun673 = new Municipio(null, "Bom Jesus da Lapa", uf5);
		Municipio mun675 = new Municipio(null, "Bom Jesus da Serra", uf5);
		Municipio mun711 = new Municipio(null, "Boninal", uf5);
		Municipio mun717 = new Municipio(null, "Bonito", uf5);
		Municipio mun723 = new Municipio(null, "Boquira", uf5);
		Municipio mun736 = new Municipio(null, "Botuporã", uf5);
		Municipio mun776 = new Municipio(null, "Brejões", uf5);
		Municipio mun777 = new Municipio(null, "Brejolândia", uf5);
		Municipio mun783 = new Municipio(null, "Brotas de Macaúbas", uf5);
		Municipio mun786 = new Municipio(null, "Brumado", uf5);
		Municipio mun792 = new Municipio(null, "Buerarema", uf5);
		Municipio mun808 = new Municipio(null, "Buritirama", uf5);
		Municipio mun818 = new Municipio(null, "Caatiba", uf5);
		Municipio mun819 = new Municipio(null, "Cabaceiras do Paraguaçu", uf5);
		Municipio mun851 = new Municipio(null, "Cachoeira", uf5);
		Municipio mun865 = new Municipio(null, "Caculé", uf5);
		Municipio mun866 = new Municipio(null, "Caém", uf5);
		Municipio mun868 = new Municipio(null, "Caetanos", uf5);
		Municipio mun871 = new Municipio(null, "Caetité", uf5);
		Municipio mun872 = new Municipio(null, "Cafarnaum", uf5);
		Municipio mun888 = new Municipio(null, "Cairu", uf5);
		Municipio mun909 = new Municipio(null, "Caldeirão Grande", uf5);
		Municipio mun913 = new Municipio(null, "Camacan", uf5);
		Municipio mun914 = new Municipio(null, "Camaçari", uf5);
		Municipio mun917 = new Municipio(null, "Camamu", uf5);
		Municipio mun955 = new Municipio(null, "Campo Alegre de Lourdes", uf5);
		Municipio mun970 = new Municipio(null, "Campo Formoso", uf5);
		Municipio mun1006 = new Municipio(null, "Canápolis", uf5);
		Municipio mun1008 = new Municipio(null, "Canarana", uf5);
		Municipio mun1011 = new Municipio(null, "Canavieiras", uf5);
		Municipio mun1012 = new Municipio(null, "Candeal", uf5);
		Municipio mun1015 = new Municipio(null, "Candeias", uf5);
		Municipio mun1017 = new Municipio(null, "Candiba", uf5);
		Municipio mun1023 = new Municipio(null, "Cândido Sales", uf5);
		Municipio mun1037 = new Municipio(null, "Cansanção", uf5);
		Municipio mun1045 = new Municipio(null, "Canudos", uf5);
		Municipio mun1057 = new Municipio(null, "Capela do Alto Alegre", uf5);
		Municipio mun1065 = new Municipio(null, "Capim Grosso", uf5);
		Municipio mun1091 = new Municipio(null, "Caraíbas", uf5);
		Municipio mun1103 = new Municipio(null, "Caravelas", uf5);
		Municipio mun1106 = new Municipio(null, "Cardeal da Silva", uf5);
		Municipio mun1115 = new Municipio(null, "Carinhanha", uf5);
		Municipio mun1157 = new Municipio(null, "Casa Nova", uf5);
		Municipio mun1177 = new Municipio(null, "Castro Alves", uf5);
		Municipio mun1190 = new Municipio(null, "Catolândia", uf5);
		Municipio mun1192 = new Municipio(null, "Catu", uf5);
		Municipio mun1197 = new Municipio(null, "Caturama", uf5);
		Municipio mun1220 = new Municipio(null, "Central", uf5);
		Municipio mun1266 = new Municipio(null, "Chorrochó", uf5);
		Municipio mun1271 = new Municipio(null, "Cícero Dantas", uf5);
		Municipio mun1276 = new Municipio(null, "Cipó", uf5);
		Municipio mun1285 = new Municipio(null, "Coaraci", uf5);
		Municipio mun1293 = new Municipio(null, "Cocos", uf5);
		Municipio mun1327 = new Municipio(null, "Conceição da Feira", uf5);
		Municipio mun1332 = new Municipio(null, "Conceição do Almeida", uf5);
		Municipio mun1336 = new Municipio(null, "Conceição do Coité", uf5);
		Municipio mun1337 = new Municipio(null, "Conceição do Jacuípe", uf5);
		Municipio mun1352 = new Municipio(null, "Conde", uf5);
		Municipio mun1353 = new Municipio(null, "Condeúba", uf5);
		Municipio mun1372 = new Municipio(null, "Contendas do Sincorá", uf5);
		Municipio mun1378 = new Municipio(null, "Coração de Maria", uf5);
		Municipio mun1382 = new Municipio(null, "Cordeiros", uf5);
		Municipio mun1389 = new Municipio(null, "Coribe", uf5);
		Municipio mun1403 = new Municipio(null, "Coronel João Sá", uf5);
		Municipio mun1421 = new Municipio(null, "Correntina", uf5);
		Municipio mun1435 = new Municipio(null, "Cotegipe", uf5);
		Municipio mun1448 = new Municipio(null, "Cravolândia", uf5);
		Municipio mun1451 = new Municipio(null, "Crisópolis", uf5);
		Municipio mun1466 = new Municipio(null, "Cristópolis", uf5);
		Municipio mun1473 = new Municipio(null, "Cruz das Almas", uf5);
		Municipio mun1505 = new Municipio(null, "Curaçá", uf5);
		Municipio mun1531 = new Municipio(null, "Dário Meira", uf5);
		Municipio mun1560 = new Municipio(null, "Dias d'Ávila", uf5);
		Municipio mun1592 = new Municipio(null, "Dom Basílio", uf5);
		Municipio mun1600 = new Municipio(null, "Dom Macedo Costa", uf5);
		Municipio mun1653 = new Municipio(null, "Elísio Medrado", uf5);
		Municipio mun1663 = new Municipio(null, "Encruzilhada", uf5);
		Municipio mun1676 = new Municipio(null, "Entre Rios", uf5);
		Municipio mun1684 = new Municipio(null, "Érico Cardoso", uf5);
		Municipio mun1708 = new Municipio(null, "Esplanada", uf5);
		Municipio mun1727 = new Municipio(null, "Euclides da Cunha", uf5);
		Municipio mun1730 = new Municipio(null, "Eunápolis", uf5);
		Municipio mun1749 = new Municipio(null, "Fátima", uf5);
		Municipio mun1758 = new Municipio(null, "Feira da Mata", uf5);
		Municipio mun1759 = new Municipio(null, "Feira de Santana", uf5);
		Municipio mun1790 = new Municipio(null, "Filadélfia", uf5);
		Municipio mun1791 = new Municipio(null, "Firmino Alves", uf5);
		Municipio mun1804 = new Municipio(null, "Floresta Azul", uf5);
		Municipio mun1823 = new Municipio(null, "Formosa do Rio Preto", uf5);
		Municipio mun1883 = new Municipio(null, "Gandu", uf5);
		Municipio mun1897 = new Municipio(null, "Gavião", uf5);
		Municipio mun1906 = new Municipio(null, "Gentio do Ouro", uf5);
		Municipio mun1917 = new Municipio(null, "Glória", uf5);
		Municipio mun1939 = new Municipio(null, "Gongogi", uf5);
		Municipio mun1951 = new Municipio(null, "Governador Mangabeira", uf5);
		Municipio mun1987 = new Municipio(null, "Guajeru", uf5);
		Municipio mun1990 = new Municipio(null, "Guanambi", uf5);
		Municipio mun2027 = new Municipio(null, "Guaratinga", uf5);
		Municipio mun2056 = new Municipio(null, "Heliópolis", uf5);
		Municipio mun2077 = new Municipio(null, "Iaçu", uf5);
		Municipio mun2095 = new Municipio(null, "Ibiassucê", uf5);
		Municipio mun2096 = new Municipio(null, "Ibicaraí", uf5);
		Municipio mun2098 = new Municipio(null, "Ibicoara", uf5);
		Municipio mun2099 = new Municipio(null, "Ibicuí", uf5);
		Municipio mun2102 = new Municipio(null, "Ibipeba", uf5);
		Municipio mun2103 = new Municipio(null, "Ibipitanga", uf5);
		Municipio mun2105 = new Municipio(null, "Ibiquera", uf5);
		Municipio mun2113 = new Municipio(null, "Ibirapitanga", uf5);
		Municipio mun2114 = new Municipio(null, "Ibirapuã", uf5);
		Municipio mun2117 = new Municipio(null, "Ibirataia", uf5);
		Municipio mun2120 = new Municipio(null, "Ibitiara", uf5);
		Municipio mun2123 = new Municipio(null, "Ibititá", uf5);
		Municipio mun2127 = new Municipio(null, "Ibotirama", uf5);
		Municipio mun2134 = new Municipio(null, "Ichu", uf5);
		Municipio mun2140 = new Municipio(null, "Igaporã", uf5);
		Municipio mun2152 = new Municipio(null, "Igrapiúna", uf5);
		Municipio mun2156 = new Municipio(null, "Iguaí", uf5);
		Municipio mun2172 = new Municipio(null, "Ilhéus", uf5);
		Municipio mun2207 = new Municipio(null, "Inhambupe", uf5);
		Municipio mun2227 = new Municipio(null, "Ipecaetá", uf5);
		Municipio mun2231 = new Municipio(null, "Ipiaú", uf5);
		Municipio mun2234 = new Municipio(null, "Ipirá", uf5);
		Municipio mun2256 = new Municipio(null, "Ipupiara", uf5);
		Municipio mun2264 = new Municipio(null, "Irajuba", uf5);
		Municipio mun2265 = new Municipio(null, "Iramaia", uf5);
		Municipio mun2270 = new Municipio(null, "Iraquara", uf5);
		Municipio mun2271 = new Municipio(null, "Irará", uf5);
		Municipio mun2275 = new Municipio(null, "Irecê", uf5);
		Municipio mun2287 = new Municipio(null, "Itabela", uf5);
		Municipio mun2289 = new Municipio(null, "Itaberaba", uf5);
		Municipio mun2296 = new Municipio(null, "Itabuna", uf5);
		Municipio mun2300 = new Municipio(null, "Itacaré", uf5);
		Municipio mun2304 = new Municipio(null, "Itaeté", uf5);
		Municipio mun2305 = new Municipio(null, "Itagi", uf5);
		Municipio mun2306 = new Municipio(null, "Itagibá", uf5);
		Municipio mun2307 = new Municipio(null, "Itagimirim", uf5);
		Municipio mun2308 = new Municipio(null, "Itaguaçu da Bahia", uf5);
		Municipio mun2330 = new Municipio(null, "Itaju do Colônia", uf5);
		Municipio mun2333 = new Municipio(null, "Itajuípe", uf5);
		Municipio mun2335 = new Municipio(null, "Itamaraju", uf5);
		Municipio mun2339 = new Municipio(null, "Itamari", uf5);
		Municipio mun2345 = new Municipio(null, "Itambé", uf5);
		Municipio mun2348 = new Municipio(null, "Itanagra", uf5);
		Municipio mun2352 = new Municipio(null, "Itanhém", uf5);
		Municipio mun2360 = new Municipio(null, "Itaparica", uf5);
		Municipio mun2361 = new Municipio(null, "Itapé", uf5);
		Municipio mun2362 = new Municipio(null, "Itapebi", uf5);
		Municipio mun2372 = new Municipio(null, "Itapetinga", uf5);
		Municipio mun2377 = new Municipio(null, "Itapicuru", uf5);
		Municipio mun2386 = new Municipio(null, "Itapitanga", uf5);
		Municipio mun2402 = new Municipio(null, "Itaquara", uf5);
		Municipio mun2407 = new Municipio(null, "Itarantim", uf5);
		Municipio mun2417 = new Municipio(null, "Itatim", uf5);
		Municipio mun2435 = new Municipio(null, "Itiruçu", uf5);
		Municipio mun2436 = new Municipio(null, "Itiúba", uf5);
		Municipio mun2438 = new Municipio(null, "Itororó", uf5);
		Municipio mun2440 = new Municipio(null, "Ituaçu", uf5);
		Municipio mun2441 = new Municipio(null, "Ituberá", uf5);
		Municipio mun2452 = new Municipio(null, "Iuiú", uf5);
		Municipio mun2465 = new Municipio(null, "Jaborandi", uf5);
		Municipio mun2471 = new Municipio(null, "Jacaraci", uf5);
		Municipio mun2482 = new Municipio(null, "Jacobina", uf5);
		Municipio mun2491 = new Municipio(null, "Jaguaquara", uf5);
		Municipio mun2494 = new Municipio(null, "Jaguarari", uf5);
		Municipio mun2501 = new Municipio(null, "Jaguaripe", uf5);
		Municipio mun2514 = new Municipio(null, "Jandaíra", uf5);
		Municipio mun2568 = new Municipio(null, "Jequié", uf5);
		Municipio mun2572 = new Municipio(null, "Jeremoabo", uf5);
		Municipio mun2582 = new Municipio(null, "Jiquiriçá", uf5);
		Municipio mun2583 = new Municipio(null, "Jitaúna", uf5);
		Municipio mun2592 = new Municipio(null, "João Dourado", uf5);
		Municipio mun2625 = new Municipio(null, "Juazeiro", uf5);
		Municipio mun2628 = new Municipio(null, "Jucuruçu", uf5);
		Municipio mun2660 = new Municipio(null, "Jussara", uf5);
		Municipio mun2662 = new Municipio(null, "Jussari", uf5);
		Municipio mun2663 = new Municipio(null, "Jussiape", uf5);
		Municipio mun2672 = new Municipio(null, "Lafaiete Coutinho", uf5);
		Municipio mun2707 = new Municipio(null, "Lagoa Real", uf5);
		Municipio mun2720 = new Municipio(null, "Laje", uf5);
		Municipio mun2726 = new Municipio(null, "Lajedão", uf5);
		Municipio mun2727 = new Municipio(null, "Lajedinho", uf5);
		Municipio mun2728 = new Municipio(null, "Lajedo do Tabocal", uf5);
		Municipio mun2733 = new Municipio(null, "Lamarão", uf5);
		Municipio mun2739 = new Municipio(null, "Lapão", uf5);
		Municipio mun2750 = new Municipio(null, "Lauro de Freitas", uf5);
		Municipio mun2763 = new Municipio(null, "Lençóis", uf5);
		Municipio mun2770 = new Municipio(null, "Licínio de Almeida", uf5);
		Municipio mun2787 = new Municipio(null, "Livramento de Nossa Senhora", uf5);
		Municipio mun2809 = new Municipio(null, "Luís Eduardo Magalhães", uf5);
		Municipio mun2828 = new Municipio(null, "Macajuba", uf5);
		Municipio mun2833 = new Municipio(null, "Macarani", uf5);
		Municipio mun2837 = new Municipio(null, "Macaúbas", uf5);
		Municipio mun2847 = new Municipio(null, "Macururé", uf5);
		Municipio mun2851 = new Municipio(null, "Madre de Deus", uf5);
		Municipio mun2854 = new Municipio(null, "Maetinga", uf5);
		Municipio mun2860 = new Municipio(null, "Maiquinique", uf5);
		Municipio mun2861 = new Municipio(null, "Mairi", uf5);
		Municipio mun2870 = new Municipio(null, "Malhada de Pedras", uf5);
		Municipio mun2872 = new Municipio(null, "Malhada", uf5);
		Municipio mun2902 = new Municipio(null, "Manoel Vitorino", uf5);
		Municipio mun2903 = new Municipio(null, "Mansidão", uf5);
		Municipio mun2919 = new Municipio(null, "Maracás", uf5);
		Municipio mun2921 = new Municipio(null, "Maragogipe", uf5);
		Municipio mun2931 = new Municipio(null, "Maraú", uf5);
		Municipio mun2939 = new Municipio(null, "Marcionílio Souza", uf5);
		Municipio mun2986 = new Municipio(null, "Mascote", uf5);
		Municipio mun2991 = new Municipio(null, "Mata de São João", uf5);
		Municipio mun3006 = new Municipio(null, "Matina", uf5);
		Municipio mun3035 = new Municipio(null, "Medeiros Neto", uf5);
		Municipio mun3055 = new Municipio(null, "Miguel Calmon", uf5);
		Municipio mun3060 = new Municipio(null, "Milagres", uf5);
		Municipio mun3089 = new Municipio(null, "Mirangaba", uf5);
		Municipio mun3093 = new Municipio(null, "Mirante", uf5);
		Municipio mun3157 = new Municipio(null, "Monte Santo", uf5);
		Municipio mun3176 = new Municipio(null, "Morpará", uf5);
		Municipio mun3187 = new Municipio(null, "Morro do Chapéu", uf5);
		Municipio mun3193 = new Municipio(null, "Mortugaba", uf5);
		Municipio mun3203 = new Municipio(null, "Mucugê", uf5);
		Municipio mun3205 = new Municipio(null, "Mucuri", uf5);
		Municipio mun3209 = new Municipio(null, "Mulungu do Morro", uf5);
		Municipio mun3213 = new Municipio(null, "Mundo Novo", uf5);
		Municipio mun3217 = new Municipio(null, "Muniz Ferreira", uf5);
		Municipio mun3219 = new Municipio(null, "Muquém de São Francisco", uf5);
		Municipio mun3226 = new Municipio(null, "Muritiba", uf5);
		Municipio mun3228 = new Municipio(null, "Mutuípe", uf5);
		Municipio mun3251 = new Municipio(null, "Nazaré", uf5);
		Municipio mun3262 = new Municipio(null, "Nilo Peçanha", uf5);
		Municipio mun3273 = new Municipio(null, "Nordestina", uf5);
		Municipio mun3305 = new Municipio(null, "Nova Canaã", uf5);
		Municipio mun3320 = new Municipio(null, "Nova Fátima", uf5);
		Municipio mun3328 = new Municipio(null, "Nova Ibiá", uf5);
		Municipio mun3335 = new Municipio(null, "Nova Itarana", uf5);
		Municipio mun3364 = new Municipio(null, "Nova Redenção", uf5);
		Municipio mun3376 = new Municipio(null, "Nova Soure", uf5);
		Municipio mun3386 = new Municipio(null, "Nova Viçosa", uf5);
		Municipio mun3404 = new Municipio(null, "Novo Horizonte", uf5);
		Municipio mun3420 = new Municipio(null, "Novo Triunfo", uf5);
		Municipio mun3444 = new Municipio(null, "Olindina", uf5);
		Municipio mun3447 = new Municipio(null, "Oliveira dos Brejinhos", uf5);
		Municipio mun3471 = new Municipio(null, "Ouriçangas", uf5);
		Municipio mun3490 = new Municipio(null, "Ourolândia", uf5);
		Municipio mun3527 = new Municipio(null, "Palmas de Monte Alto", uf5);
		Municipio mun3541 = new Municipio(null, "Palmeiras", uf5);
		Municipio mun3581 = new Municipio(null, "Paramirim", uf5);
		Municipio mun3601 = new Municipio(null, "Paratinga", uf5);
		Municipio mun3612 = new Municipio(null, "Paripiranga", uf5);
		Municipio mun3651 = new Municipio(null, "Pau Brasil", uf5);
		Municipio mun3668 = new Municipio(null, "Paulo Afonso", uf5);
		Municipio mun3678 = new Municipio(null, "Pé de Serra", uf5);
		Municipio mun3699 = new Municipio(null, "Pedrão", uf5);
		Municipio mun3711 = new Municipio(null, "Pedro Alexandre", uf5);
		Municipio mun3764 = new Municipio(null, "Piatã", uf5);
		Municipio mun3777 = new Municipio(null, "Pilão Arcado", uf5);
		Municipio mun3789 = new Municipio(null, "Pindaí", uf5);
		Municipio mun3793 = new Municipio(null, "Pindobaçu", uf5);
		Municipio mun3814 = new Municipio(null, "Pintadas", uf5);
		Municipio mun3826 = new Municipio(null, "Piraí do Norte", uf5);
		Municipio mun3855 = new Municipio(null, "Piripá", uf5);
		Municipio mun3857 = new Municipio(null, "Piritiba", uf5);
		Municipio mun3871 = new Municipio(null, "Planaltino", uf5);
		Municipio mun3877 = new Municipio(null, "Planalto", uf5);
		Municipio mun3892 = new Municipio(null, "Poções", uf5);
		Municipio mun3896 = new Municipio(null, "Pojuca", uf5);
		Municipio mun3926 = new Municipio(null, "Ponto Novo", uf5);
		Municipio mun3969 = new Municipio(null, "Porto Seguro", uf5);
		Municipio mun3981 = new Municipio(null, "Potiraguá", uf5);
		Municipio mun3992 = new Municipio(null, "Prado", uf5);
		Municipio mun4012 = new Municipio(null, "Presidente Dutra", uf5);
		Municipio mun4016 = new Municipio(null, "Presidente Jânio Quadros", uf5);
		Municipio mun4030 = new Municipio(null, "Presidente Tancredo Neves", uf5);
		Municipio mun4067 = new Municipio(null, "Queimadas", uf5);
		Municipio mun4075 = new Municipio(null, "Quijingue", uf5);
		Municipio mun4087 = new Municipio(null, "Quixabeira", uf5);
		Municipio mun4094 = new Municipio(null, "Rafael Jambeiro", uf5);
		Municipio mun4120 = new Municipio(null, "Remanso", uf5);
		Municipio mun4133 = new Municipio(null, "Retirolândia", uf5);
		Municipio mun4134 = new Municipio(null, "Riachão das Neves", uf5);
		Municipio mun4137 = new Municipio(null, "Riachão do Jacuípe", uf5);
		Municipio mun4146 = new Municipio(null, "Riacho de Santana", uf5);
		Municipio mun4157 = new Municipio(null, "Ribeira do Amparo", uf5);
		Municipio mun4159 = new Municipio(null, "Ribeira do Pombal", uf5);
		Municipio mun4167 = new Municipio(null, "Ribeirão do Largo", uf5);
		Municipio mun4202 = new Municipio(null, "Rio de Contas", uf5);
		Municipio mun4204 = new Municipio(null, "Rio do Antônio", uf5);
		Municipio mun4208 = new Municipio(null, "Rio do Pires", uf5);
		Municipio mun4237 = new Municipio(null, "Rio Real", uf5);
		Municipio mun4255 = new Municipio(null, "Rodelas", uf5);
		Municipio mun4290 = new Municipio(null, "Ruy Barbosa", uf5);
		Municipio mun4311 = new Municipio(null, "Salinas da Margarida", uf5);
		Municipio mun4330 = new Municipio(null, "Salvador", uf5);
		Municipio mun4351 = new Municipio(null, "Santa Bárbara", uf5);
		Municipio mun4353 = new Municipio(null, "Santa Brígida", uf5);
		Municipio mun4361 = new Municipio(null, "Santa Cruz Cabrália", uf5);
		Municipio mun4365 = new Municipio(null, "Santa Cruz da Vitória", uf5);
		Municipio mun4402 = new Municipio(null, "Santa Inês", uf5);
		Municipio mun4422 = new Municipio(null, "Santa Luzia", uf5);
		Municipio mun4427 = new Municipio(null, "Santa Maria da Vitória", uf5);
		Municipio mun4448 = new Municipio(null, "Santa Rita de Cássia", uf5);
		Municipio mun4475 = new Municipio(null, "Santa Teresinha", uf5);
		Municipio mun4489 = new Municipio(null, "Santaluz", uf5);
		Municipio mun4518 = new Municipio(null, "Santana", uf5);
		Municipio mun4519 = new Municipio(null, "Santanópolis", uf5);
		Municipio mun4529 = new Municipio(null, "Santo Amaro", uf5);
		Municipio mun4540 = new Municipio(null, "Santo Antônio de Jesus", uf5);
		Municipio mun4570 = new Municipio(null, "Santo Estêvão", uf5);
		Municipio mun4608 = new Municipio(null, "São Desidério", uf5);
		Municipio mun4621 = new Municipio(null, "São Domingos", uf5);
		Municipio mun4624 = new Municipio(null, "São Felipe", uf5);
		Municipio mun4628 = new Municipio(null, "São Félix do Coribe", uf5);
		Municipio mun4632 = new Municipio(null, "São Félix", uf5);
		Municipio mun4643 = new Municipio(null, "São Francisco do Conde", uf5);
		Municipio mun4659 = new Municipio(null, "São Gabriel", uf5);
		Municipio mun4673 = new Municipio(null, "São Gonçalo dos Campos", uf5);
		Municipio mun4748 = new Municipio(null, "São José da Vitória", uf5);
		Municipio mun4774 = new Municipio(null, "São José do Jacuípe", uf5);
		Municipio mun4830 = new Municipio(null, "São Miguel das Matas", uf5);
		Municipio mun4895 = new Municipio(null, "São Sebastião do Passé", uf5);
		Municipio mun4923 = new Municipio(null, "Sapeaçu", uf5);
		Municipio mun4938 = new Municipio(null, "Sátiro Dias", uf5);
		Municipio mun4941 = new Municipio(null, "Saubara", uf5);
		Municipio mun4944 = new Municipio(null, "Saúde", uf5);
		Municipio mun4946 = new Municipio(null, "Seabra", uf5);
		Municipio mun4950 = new Municipio(null, "Sebastião Laranjeiras", uf5);
		Municipio mun4976 = new Municipio(null, "Senhor do Bonfim", uf5);
		Municipio mun4981 = new Municipio(null, "Sento Sé", uf5);
		Municipio mun4998 = new Municipio(null, "Serra do Ramalho", uf5);
		Municipio mun5001 = new Municipio(null, "Serra Dourada", uf5);
		Municipio mun5006 = new Municipio(null, "Serra Preta", uf5);
		Municipio mun5020 = new Municipio(null, "Serrinha", uf5);
		Municipio mun5023 = new Municipio(null, "Serrolândia", uf5);
		Municipio mun5052 = new Municipio(null, "Simões Filho", uf5);
		Municipio mun5063 = new Municipio(null, "Sítio do Mato", uf5);
		Municipio mun5064 = new Municipio(null, "Sítio do Quinto", uf5);
		Municipio mun5069 = new Municipio(null, "Sobradinho", uf5);
		Municipio mun5089 = new Municipio(null, "Souto Soares", uf5);
		Municipio mun5110 = new Municipio(null, "Tabocas do Brejo Velho", uf5);
		Municipio mun5139 = new Municipio(null, "Tanhaçu", uf5);
		Municipio mun5142 = new Municipio(null, "Tanque Novo", uf5);
		Municipio mun5143 = new Municipio(null, "Tanquinho", uf5);
		Municipio mun5150 = new Municipio(null, "Taperoá", uf5);
		Municipio mun5156 = new Municipio(null, "Tapiramutá", uf5);
		Municipio mun5184 = new Municipio(null, "Teixeira de Freitas", uf5);
		Municipio mun5198 = new Municipio(null, "Teodoro Sampaio", uf5);
		Municipio mun5199 = new Municipio(null, "Teofilândia", uf5);
		Municipio mun5201 = new Municipio(null, "Teolândia", uf5);
		Municipio mun5214 = new Municipio(null, "Terra Nova", uf5);
		Municipio mun5271 = new Municipio(null, "Tremedal", uf5);
		Municipio mun5303 = new Municipio(null, "Tucano", uf5);
		Municipio mun5341 = new Municipio(null, "Uauá", uf5);
		Municipio mun5344 = new Municipio(null, "Ubaíra", uf5);
		Municipio mun5345 = new Municipio(null, "Ubaitaba", uf5);
		Municipio mun5349 = new Municipio(null, "Ubatã", uf5);
		Municipio mun5357 = new Municipio(null, "Uibaí", uf5);
		Municipio mun5365 = new Municipio(null, "Umburanas", uf5);
		Municipio mun5370 = new Municipio(null, "Una", uf5);
		Municipio mun5384 = new Municipio(null, "Urandi", uf5);
		Municipio mun5396 = new Municipio(null, "Uruçuca", uf5);
		Municipio mun5407 = new Municipio(null, "Utinga", uf5);
		Municipio mun5417 = new Municipio(null, "Valença", uf5);
		Municipio mun5418 = new Municipio(null, "Valente", uf5);
		Municipio mun5443 = new Municipio(null, "Várzea da Roça", uf5);
		Municipio mun5444 = new Municipio(null, "Várzea do Poço", uf5);
		Municipio mun5447 = new Municipio(null, "Várzea Nova", uf5);
		Municipio mun5451 = new Municipio(null, "Varzedo", uf5);
		Municipio mun5464 = new Municipio(null, "Vera Cruz", uf5);
		Municipio mun5471 = new Municipio(null, "Vereda", uf5);
		Municipio mun5529 = new Municipio(null, "Vitória da Conquista", uf5);
		Municipio mun5542 = new Municipio(null, "Wagner", uf5);
		Municipio mun5545 = new Municipio(null, "Wanderley", uf5);
		Municipio mun5548 = new Municipio(null, "Wenceslau Guimarães", uf5);
		Municipio mun5560 = new Municipio(null, "Xique-Xique", uf5);

		municipioRepository.saveAll(Arrays.asList(mun1037, mun1045, mun1057, mun1065, mun1091, mun1103, mun1106, mun1115, 
			mun1157, mun1177, mun1190, mun1192, mun1197, mun1220, mun1266, mun1271, 
			mun120, mun195, mun197, mun198, mun212, mun227, mun229, mun240, 
			mun1276, mun1285, mun1293, mun1327, mun1332, mun1336, mun1337, mun1352, 
			mun1353, mun1372, mun1378, mun1382, mun1389, mun1403, mun1421, mun1435, 
			mun1448, mun1451, mun1466, mun1473, mun1505, mun1531, mun1560, mun1592, 
			mun1600, mun1653, mun1663, mun1676, mun1684, mun1708, mun1727, mun1730, 
			mun1749, mun1758, mun1759, mun1790, mun1791, mun1804, mun1823, mun1883, 
			mun1897, mun1906, mun1917, mun1939, mun1951, mun1987, mun1990, mun2027, 
			mun2056, mun2077, mun2095, mun2096, mun2098, mun2099, mun2102, mun2103, 
			mun2105, mun2113, mun2114, mun2117, mun2120, mun2123, mun2127, mun2134, 
			mun2140, mun2152, mun2156, mun2172, mun2207, mun2227, mun2231, mun2234, 
			mun2256, mun2264, mun2265, mun2270, mun2271, mun2275, mun2287, mun2289, 
			mun2296, mun2300, mun2304, mun2305, mun2306, mun2307, mun2308, mun2330, 
			mun2333, mun2335, mun2339, mun2345, mun2348, mun2352, mun2360, mun2361, 
			mun2362, mun2372, mun2377, mun2386, mun2402, mun2407, mun2417, mun2435, 
			mun2436, mun2438, mun2440, mun2441, mun2452, mun2465, mun2471, mun2482, 
			mun244, mun255, mun259, mun263, mun283, mun285, mun297, mun299, 
			mun2491, mun2494, mun2501, mun2514, mun2568, mun2572, mun2582, mun2583, 
			mun2592, mun2625, mun2628, mun2660, mun2662, mun2663, mun2672, mun2707, 
			mun2720, mun2726, mun2727, mun2728, mun2733, mun2739, mun2750, mun2763, 
			mun2770, mun2787, mun2809, mun2828, mun2833, mun2837, mun2847, mun2851, 
			mun2854, mun2860, mun2861, mun2870, mun2872, mun2902, mun2903, mun2919, 
			mun2921, mun2931, mun2939, mun2986, mun2991, mun3006, mun3035, mun3055, 
			mun301, mun324, mun353, mun356, mun430, mun457, mun460, mun485, 
			mun3060, mun3089, mun3093, mun3157, mun3176, mun3187, mun3193, mun3203, 
			mun3205, mun3209, mun3213, mun3217, mun3219, mun3226, mun3228, mun3251, 
			mun3262, mun3273, mun3305, mun3320, mun3328, mun3335, mun3364, mun3376, 
			mun3386, mun3404, mun3420, mun3444, mun3447, mun3471, mun3490, mun3527, 
			mun3541, mun3581, mun3601, mun3612, mun3651, mun3668, mun3678, mun3699, 
			mun3711, mun3764, mun3777, mun3789, mun3793, mun3814, mun3826, mun3855, 
			mun3857, mun3871, mun3877, mun3892, mun3896, mun3926, mun3969, mun3981, 
			mun3992, mun4012, mun4016, mun4030, mun4067, mun4075, mun4087, mun4094, 
			mun4120, mun4133, mun4134, mun4137, mun4146, mun4157, mun4159, mun4167, 
			mun4202, mun4204, mun4208, mun4237, mun4255, mun4290, mun4311, mun4330, 
			mun4351, mun4353, mun4361, mun4365, mun4402, mun4422, mun4427, mun4448, 
			mun4475, mun4489, mun4518, mun4519, mun4529, mun4540, mun4570, mun4608, 
			mun4621, mun4624, mun4628, mun4632, mun4643, mun4659, mun4673, mun4748, 
			mun4774, mun4830, mun4895, mun4923, mun4938, mun4941, mun4944, mun4946, 
			mun4950, mun4976, mun4981, mun4998, mun5001, mun5006, mun5020, mun5023, 
			mun5052, mun5063, mun5064, mun5069, mun5089, mun5110, mun5139, mun5142, 
			mun507, mun517, mun522, mun528, mun535, mun541, mun547, mun550, 
			mun5143, mun5150, mun5156, mun5184, mun5198, mun5199, mun5201, mun5214, 
			mun5271, mun5303, mun5341, mun5344, mun5345, mun5349, mun5357, mun5365, 
			mun5370, mun5384, mun5396, mun5407, mun5417, mun5418, mun5443, mun5444, 
			mun5447, mun5451, mun5464, mun5471, mun5529, mun5542, mun5545, mun5548, 
			mun552, mun589, mun590, mun628, mun637, mun649, mun673, mun675, 
			mun5560, 
			mun711, mun717, mun723, mun736, mun776, mun777, mun783, mun786, 
			mun792, mun808, mun818, mun819, mun851, mun865, mun866, mun868, 
			mun8, mun9, mun19, mun36, mun58, mun83, mun93, mun100, 
			mun871, mun872, mun888, mun909, mun913, mun914, mun917, mun955, 
			mun970, mun1006, mun1008, mun1011, mun1012, mun1015, mun1017, mun1023));

	}
	
	private void instanciaMunUf6(UF uf6) {
		Municipio mun7 = new Municipio(null, "Abaiara", uf6);
		Municipio mun21 = new Municipio(null, "Acarape", uf6);
		Municipio mun22 = new Municipio(null, "Acaraú", uf6);
		Municipio mun26 = new Municipio(null, "Acopiara", uf6);
		Municipio mun84 = new Municipio(null, "Aiuaba", uf6);
		Municipio mun97 = new Municipio(null, "Alcântaras", uf6);
		Municipio mun137 = new Municipio(null, "Altaneira", uf6);
		Municipio mun166 = new Municipio(null, "Alto Santo", uf6);
		Municipio mun204 = new Municipio(null, "Amontada", uf6);
		Municipio mun256 = new Municipio(null, "Antonina do Norte", uf6);
		Municipio mun288 = new Municipio(null, "Apuiarés", uf6);
		Municipio mun291 = new Municipio(null, "Aquiraz", uf6);
		Municipio mun298 = new Municipio(null, "Aracati", uf6);
		Municipio mun305 = new Municipio(null, "Aracoiaba", uf6);
		Municipio mun345 = new Municipio(null, "Ararendá", uf6);
		Municipio mun348 = new Municipio(null, "Araripe", uf6);
		Municipio mun355 = new Municipio(null, "Aratuba", uf6);
		Municipio mun387 = new Municipio(null, "Arneiroz", uf6);
		Municipio mun409 = new Municipio(null, "Assaré", uf6);
		Municipio mun436 = new Municipio(null, "Aurora", uf6);
		Municipio mun461 = new Municipio(null, "Baixio", uf6);
		Municipio mun475 = new Municipio(null, "Banabuiú", uf6);
		Municipio mun497 = new Municipio(null, "Barbalha", uf6);
		Municipio mun539 = new Municipio(null, "Barreira", uf6);
		Municipio mun551 = new Municipio(null, "Barro", uf6);
		Municipio mun554 = new Municipio(null, "Barroquinha", uf6);
		Municipio mun564 = new Municipio(null, "Baturité", uf6);
		Municipio mun568 = new Municipio(null, "Beberibe", uf6);
		Municipio mun569 = new Municipio(null, "Bela Cruz", uf6);
		Municipio mun640 = new Municipio(null, "Boa Viagem", uf6);
		Municipio mun774 = new Municipio(null, "Brejo Santo", uf6);
		Municipio mun933 = new Municipio(null, "Camocim", uf6);
		Municipio mun996 = new Municipio(null, "Campos Sales", uf6);
		Municipio mun1033 = new Municipio(null, "Canindé", uf6);
		Municipio mun1070 = new Municipio(null, "Capistrano", uf6);
		Municipio mun1114 = new Municipio(null, "Caridade", uf6);
		Municipio mun1117 = new Municipio(null, "Cariré", uf6);
		Municipio mun1119 = new Municipio(null, "Caririaçu", uf6);
		Municipio mun1120 = new Municipio(null, "Cariús", uf6);
		Municipio mun1141 = new Municipio(null, "Carnaubal", uf6);
		Municipio mun1161 = new Municipio(null, "Cascavel", uf6);
		Municipio mun1184 = new Municipio(null, "Catarina", uf6);
		Municipio mun1195 = new Municipio(null, "Catunda", uf6);
		Municipio mun1200 = new Municipio(null, "Caucaia", uf6);
		Municipio mun1213 = new Municipio(null, "Cedro", uf6);
		Municipio mun1258 = new Municipio(null, "Chaval", uf6);
		Municipio mun1264 = new Municipio(null, "Choró", uf6);
		Municipio mun1265 = new Municipio(null, "Chorozinho", uf6);
		Municipio mun1386 = new Municipio(null, "Coreaú", uf6);
		Municipio mun1445 = new Municipio(null, "Crateús", uf6);
		Municipio mun1446 = new Municipio(null, "Crato", uf6);
		Municipio mun1469 = new Municipio(null, "Croatá", uf6);
		Municipio mun1476 = new Municipio(null, "Cruz", uf6);
		Municipio mun1543 = new Municipio(null, "Deputado Irapuan Pinheiro", uf6);
		Municipio mun1683 = new Municipio(null, "Ererê", uf6);
		Municipio mun1731 = new Municipio(null, "Eusébio", uf6);
		Municipio mun1741 = new Municipio(null, "Farias Brito", uf6);
		Municipio mun1830 = new Municipio(null, "Forquilha", uf6);
		Municipio mun1836 = new Municipio(null, "Fortaleza", uf6);
		Municipio mun1837 = new Municipio(null, "Fortim", uf6);
		Municipio mun1857 = new Municipio(null, "Frecheirinha", uf6);
		Municipio mun1904 = new Municipio(null, "General Sampaio", uf6);
		Municipio mun1956 = new Municipio(null, "Graça", uf6);
		Municipio mun1964 = new Municipio(null, "Granja", uf6);
		Municipio mun1965 = new Municipio(null, "Granjeiro", uf6);
		Municipio mun1971 = new Municipio(null, "Groaíras", uf6);
		Municipio mun1984 = new Municipio(null, "Guaiúba", uf6);
		Municipio mun2005 = new Municipio(null, "Guaraciaba do Norte", uf6);
		Municipio mun2011 = new Municipio(null, "Guaramiranga", uf6);
		Municipio mun2061 = new Municipio(null, "Hidrolândia", uf6);
		Municipio mun2066 = new Municipio(null, "Horizonte", uf6);
		Municipio mun2083 = new Municipio(null, "Ibaretama", uf6);
		Municipio mun2093 = new Municipio(null, "Ibiapina", uf6);
		Municipio mun2100 = new Municipio(null, "Ibicuitinga", uf6);
		Municipio mun2128 = new Municipio(null, "Icapuí", uf6);
		Municipio mun2135 = new Municipio(null, "Icó", uf6);
		Municipio mun2163 = new Municipio(null, "Iguatu", uf6);
		Municipio mun2195 = new Municipio(null, "Independência", uf6);
		Municipio mun2222 = new Municipio(null, "Ipaporanga", uf6);
		Municipio mun2224 = new Municipio(null, "Ipaumirim", uf6);
		Municipio mun2247 = new Municipio(null, "Ipu", uf6);
		Municipio mun2253 = new Municipio(null, "Ipueiras", uf6);
		Municipio mun2259 = new Municipio(null, "Iracema", uf6);
		Municipio mun2274 = new Municipio(null, "Irauçuba", uf6);
		Municipio mun2318 = new Municipio(null, "Itaiçaba", uf6);
		Municipio mun2324 = new Municipio(null, "Itaitinga", uf6);
		Municipio mun2358 = new Municipio(null, "Itapagé", uf6);
		Municipio mun2378 = new Municipio(null, "Itapipoca", uf6);
		Municipio mun2387 = new Municipio(null, "Itapiúna", uf6);
		Municipio mun2409 = new Municipio(null, "Itarema", uf6);
		Municipio mun2419 = new Municipio(null, "Itatira", uf6);
		Municipio mun2496 = new Municipio(null, "Jaguaretama", uf6);
		Municipio mun2499 = new Municipio(null, "Jaguaribara", uf6);
		Municipio mun2500 = new Municipio(null, "Jaguaribe", uf6);
		Municipio mun2503 = new Municipio(null, "Jaguaruana", uf6);
		Municipio mun2545 = new Municipio(null, "Jardim", uf6);
		Municipio mun2555 = new Municipio(null, "Jati", uf6);
		Municipio mun2580 = new Municipio(null, "Jijoca de Jericoacoara", uf6);
		Municipio mun2623 = new Municipio(null, "Juazeiro do Norte", uf6);
		Municipio mun2626 = new Municipio(null, "Jucás", uf6);
		Municipio mun2754 = new Municipio(null, "Lavras da Mangabeira", uf6);
		Municipio mun2778 = new Municipio(null, "Limoeiro do Norte", uf6);
		Municipio mun2848 = new Municipio(null, "Madalena", uf6);
		Municipio mun2918 = new Municipio(null, "Maracanaú", uf6);
		Municipio mun2924 = new Municipio(null, "Maranguape", uf6);
		Municipio mun2940 = new Municipio(null, "Marco", uf6);
		Municipio mun2979 = new Municipio(null, "Martinópole", uf6);
		Municipio mun2988 = new Municipio(null, "Massapê", uf6);
		Municipio mun3031 = new Municipio(null, "Mauriti", uf6);
		Municipio mun3048 = new Municipio(null, "Meruoca", uf6);
		Municipio mun3061 = new Municipio(null, "Milagres", uf6);
		Municipio mun3062 = new Municipio(null, "Milhã", uf6);
		Municipio mun3084 = new Municipio(null, "Miraíma", uf6);
		Municipio mun3102 = new Municipio(null, "Missão Velha", uf6);
		Municipio mun3115 = new Municipio(null, "Mombaça", uf6);
		Municipio mun3125 = new Municipio(null, "Monsenhor Tabosa", uf6);
		Municipio mun3170 = new Municipio(null, "Morada Nova", uf6);
		Municipio mun3171 = new Municipio(null, "Moraújo", uf6);
		Municipio mun3179 = new Municipio(null, "Morrinhos", uf6);
		Municipio mun3202 = new Municipio(null, "Mucambo", uf6);
		Municipio mun3211 = new Municipio(null, "Mulungu", uf6);
		Municipio mun3354 = new Municipio(null, "Nova Olinda", uf6);
		Municipio mun3369 = new Municipio(null, "Nova Russas", uf6);
		Municipio mun3412 = new Municipio(null, "Novo Oriente", uf6);
		Municipio mun3425 = new Municipio(null, "Ocara", uf6);
		Municipio mun3463 = new Municipio(null, "Orós", uf6);
		Municipio mun3494 = new Municipio(null, "Pacajus", uf6);
		Municipio mun3497 = new Municipio(null, "Pacatuba", uf6);
		Municipio mun3499 = new Municipio(null, "Pacoti", uf6);
		Municipio mun3500 = new Municipio(null, "Pacujá", uf6);
		Municipio mun3519 = new Municipio(null, "Palhano", uf6);
		Municipio mun3523 = new Municipio(null, "Palmácia", uf6);
		Municipio mun3565 = new Municipio(null, "Paracuru", uf6);
		Municipio mun3573 = new Municipio(null, "Paraipaba", uf6);
		Municipio mun3580 = new Municipio(null, "Parambu", uf6);
		Municipio mun3582 = new Municipio(null, "Paramoti", uf6);
		Municipio mun3687 = new Municipio(null, "Pedra Branca", uf6);
		Municipio mun3729 = new Municipio(null, "Penaforte", uf6);
		Municipio mun3735 = new Municipio(null, "Pentecoste", uf6);
		Municipio mun3744 = new Municipio(null, "Pereiro", uf6);
		Municipio mun3796 = new Municipio(null, "Pindoretama", uf6);
		Municipio mun3819 = new Municipio(null, "Piquet Carneiro", uf6);
		Municipio mun3854 = new Municipio(null, "Pires Ferreira", uf6);
		Municipio mun3928 = new Municipio(null, "Poranga", uf6);
		Municipio mun3936 = new Municipio(null, "Porteiras", uf6);
		Municipio mun3979 = new Municipio(null, "Potengi", uf6);
		Municipio mun3983 = new Municipio(null, "Potiretama", uf6);
		Municipio mun4084 = new Municipio(null, "Quiterianópolis", uf6);
		Municipio mun4088 = new Municipio(null, "Quixadá", uf6);
		Municipio mun4089 = new Municipio(null, "Quixelô", uf6);
		Municipio mun4090 = new Municipio(null, "Quixeramobim", uf6);
		Municipio mun4091 = new Municipio(null, "Quixeré", uf6);
		Municipio mun4112 = new Municipio(null, "Redenção", uf6);
		Municipio mun4123 = new Municipio(null, "Reriutaba", uf6);
		Municipio mun4288 = new Municipio(null, "Russas", uf6);
		Municipio mun4295 = new Municipio(null, "Saboeiro", uf6);
		Municipio mun4314 = new Municipio(null, "Salitre", uf6);
		Municipio mun4445 = new Municipio(null, "Santa Quitéria", uf6);
		Municipio mun4497 = new Municipio(null, "Santana do Acaraú", uf6);
		Municipio mun4499 = new Municipio(null, "Santana do Cariri", uf6);
		Municipio mun4581 = new Municipio(null, "São Benedito", uf6);
		Municipio mun4666 = new Municipio(null, "São Gonçalo do Amarante", uf6);
		Municipio mun4708 = new Municipio(null, "São João do Jaguaribe", uf6);
		Municipio mun4808 = new Municipio(null, "São Luís do Curu", uf6);
		Municipio mun4971 = new Municipio(null, "Senador Pompeu", uf6);
		Municipio mun4973 = new Municipio(null, "Senador Sá", uf6);
		Municipio mun5071 = new Municipio(null, "Sobral", uf6);
		Municipio mun5080 = new Municipio(null, "Solonópole", uf6);
		Municipio mun5112 = new Municipio(null, "Tabuleiro do Norte", uf6);
		Municipio mun5133 = new Municipio(null, "Tamboril", uf6);
		Municipio mun5173 = new Municipio(null, "Tarrafas", uf6);
		Municipio mun5179 = new Municipio(null, "Tauá", uf6);
		Municipio mun5189 = new Municipio(null, "Tejuçuoca", uf6);
		Municipio mun5222 = new Municipio(null, "Tianguá", uf6);
		Municipio mun5267 = new Municipio(null, "Trairi", uf6);
		Municipio mun5333 = new Municipio(null, "Tururu", uf6);
		Municipio mun5346 = new Municipio(null, "Ubajara", uf6);
		Municipio mun5362 = new Municipio(null, "Umari", uf6);
		Municipio mun5368 = new Municipio(null, "Umirim", uf6);
		Municipio mun5393 = new Municipio(null, "Uruburetama", uf6);
		Municipio mun5401 = new Municipio(null, "Uruoca", uf6);
		Municipio mun5438 = new Municipio(null, "Varjota", uf6);
		Municipio mun5440 = new Municipio(null, "Várzea Alegre", uf6);
		Municipio mun5488 = new Municipio(null, "Viçosa do Ceará", uf6);

		municipioRepository.saveAll(Arrays.asList(mun1161, mun1184, mun1195, mun1200, mun1213, mun1258, mun1264, mun1265, 
			mun1386, mun1445, mun1446, mun1469, mun1476, mun1543, mun1683, mun1731, 
			mun1741, mun1830, mun1836, mun1837, mun1857, mun1904, mun1956, mun1964, 
			mun1965, mun1971, mun1984, mun2005, mun2011, mun2061, mun2066, mun2083, 
			mun204, mun256, mun288, mun291, mun298, mun305, mun345, mun348, 
			mun2093, mun2100, mun2128, mun2135, mun2163, mun2195, mun2222, mun2224, 
			mun2247, mun2253, mun2259, mun2274, mun2318, mun2324, mun2358, mun2378, 
			mun2387, mun2409, mun2419, mun2496, mun2499, mun2500, mun2503, mun2545, 
			mun2555, mun2580, mun2623, mun2626, mun2754, mun2778, mun2848, mun2918, 
			mun2924, mun2940, mun2979, mun2988, mun3031, mun3048, mun3061, mun3062, 
			mun3084, mun3102, mun3115, mun3125, mun3170, mun3171, mun3179, mun3202, 
			mun3211, mun3354, mun3369, mun3412, mun3425, mun3463, mun3494, mun3497, 
			mun3499, mun3500, mun3519, mun3523, mun3565, mun3573, mun3580, mun3582, 
			mun355, mun387, mun409, mun436, mun461, mun475, mun497, mun539, 
			mun3687, mun3729, mun3735, mun3744, mun3796, mun3819, mun3854, mun3928, 
			mun3936, mun3979, mun3983, mun4084, mun4088, mun4089, mun4090, mun4091, 
			mun4112, mun4123, mun4288, mun4295, mun4314, mun4445, mun4497, mun4499, 
			mun4581, mun4666, mun4708, mun4808, mun4971, mun4973, mun5071, mun5080, 
			mun5112, mun5133, mun5173, mun5179, mun5189, mun5222, mun5267, mun5333, 
			mun5346, mun5362, mun5368, mun5393, mun5401, mun5438, mun5440, mun5488, 
			mun551, mun554, mun564, mun568, mun569, mun640, mun774, mun933, 
			mun7, mun21, mun22, mun26, mun84, mun97, mun137, mun166, 
			mun996, mun1033, mun1070, mun1114, mun1117, mun1119, mun1120, mun1141));

	}
	
	private void instanciaMunUf7(UF uf7) {
		Municipio mun755 = new Municipio(null, "Brasília", uf7);

		municipioRepository.saveAll(Arrays.asList(mun755)); 

	}
	
	private void instanciaMunUf8(UF uf8) {
		Municipio mun1 = new Municipio(null, "Afonso Cláudio", uf8);
		Municipio mun55 = new Municipio(null, "Água Doce do Norte", uf8);
		Municipio mun79 = new Municipio(null, "Águia Branca", uf8);
		Municipio mun103 = new Municipio(null, "Alegre", uf8);
		Municipio mun112 = new Municipio(null, "Alfredo Chaves", uf8);
		Municipio mun165 = new Municipio(null, "Alto Rio Novo", uf8);
		Municipio mun226 = new Municipio(null, "Anchieta", uf8);
		Municipio mun277 = new Municipio(null, "Apiacá", uf8);
		Municipio mun306 = new Municipio(null, "Aracruz", uf8);
		Municipio mun423 = new Municipio(null, "Atilio Vivacqua", uf8);
		Municipio mun462 = new Municipio(null, "Baixo Guandu", uf8);
		Municipio mun512 = new Municipio(null, "Barra de São Francisco", uf8);
		Municipio mun635 = new Municipio(null, "Boa Esperança", uf8);
		Municipio mun682 = new Municipio(null, "Bom Jesus do Norte", uf8);
		Municipio mun762 = new Municipio(null, "Brejetuba", uf8);
		Municipio mun856 = new Municipio(null, "Cachoeiro de Itapemirim", uf8);
		Municipio mun1112 = new Municipio(null, "Cariacica", uf8);
		Municipio mun1175 = new Municipio(null, "Castelo", uf8);
		Municipio mun1301 = new Municipio(null, "Colatina", uf8);
		Municipio mun1326 = new Municipio(null, "Conceição da Barra", uf8);
		Municipio mun1335 = new Municipio(null, "Conceição do Castelo", uf8);
		Municipio mun1571 = new Municipio(null, "Divino de São Lourenço", uf8);
		Municipio mun1606 = new Municipio(null, "Domingos Martins", uf8);
		Municipio mun1615 = new Municipio(null, "Dores do Rio Preto", uf8);
		Municipio mun1641 = new Municipio(null, "Ecoporanga", uf8);
		Municipio mun1872 = new Municipio(null, "Fundão", uf8);
		Municipio mun1949 = new Municipio(null, "Governador Lindenberg", uf8);
		Municipio mun1976 = new Municipio(null, "Guaçuí", uf8);
		Municipio mun2021 = new Municipio(null, "Guarapari", uf8);
		Municipio mun2086 = new Municipio(null, "Ibatiba", uf8);
		Municipio mun2109 = new Municipio(null, "Ibiraçu", uf8);
		Municipio mun2122 = new Municipio(null, "Ibitirama", uf8);
		Municipio mun2136 = new Municipio(null, "Iconha", uf8);
		Municipio mun2279 = new Municipio(null, "Irupi", uf8);
		Municipio mun2309 = new Municipio(null, "Itaguaçu", uf8);
		Municipio mun2368 = new Municipio(null, "Itapemirim", uf8);
		Municipio mun2406 = new Municipio(null, "Itarana", uf8);
		Municipio mun2453 = new Municipio(null, "Iúna", uf8);
		Municipio mun2495 = new Municipio(null, "Jaguaré", uf8);
		Municipio mun2575 = new Municipio(null, "Jerônimo Monteiro", uf8);
		Municipio mun2595 = new Municipio(null, "João Neiva", uf8);
		Municipio mun2740 = new Municipio(null, "Laranja da Terra", uf8);
		Municipio mun2785 = new Municipio(null, "Linhares", uf8);
		Municipio mun2905 = new Municipio(null, "Mantenópolis", uf8);
		Municipio mun2929 = new Municipio(null, "Marataízes", uf8);
		Municipio mun2945 = new Municipio(null, "Marechal Floriano", uf8);
		Municipio mun2961 = new Municipio(null, "Marilândia", uf8);
		Municipio mun3065 = new Municipio(null, "Mimoso do Sul", uf8);
		Municipio mun3128 = new Municipio(null, "Montanha", uf8);
		Municipio mun3206 = new Municipio(null, "Mucurici", uf8);
		Municipio mun3218 = new Municipio(null, "Muniz Freire", uf8);
		Municipio mun3220 = new Municipio(null, "Muqui", uf8);
		Municipio mun3383 = new Municipio(null, "Nova Venécia", uf8);
		Municipio mun3554 = new Municipio(null, "Pancas", uf8);
		Municipio mun3713 = new Municipio(null, "Pedro Canário", uf8);
		Municipio mun3813 = new Municipio(null, "Pinheiros", uf8);
		Municipio mun3865 = new Municipio(null, "Piúma", uf8);
		Municipio mun3923 = new Municipio(null, "Ponto Belo", uf8);
		Municipio mun4021 = new Municipio(null, "Presidente Kennedy", uf8);
		Municipio mun4184 = new Municipio(null, "Rio Bananal", uf8);
		Municipio mun4227 = new Municipio(null, "Rio Novo do Sul", uf8);
		Municipio mun4410 = new Municipio(null, "Santa Leopoldina", uf8);
		Municipio mun4430 = new Municipio(null, "Santa Maria de Jetibá", uf8);
		Municipio mun4473 = new Municipio(null, "Santa Teresa", uf8);
		Municipio mun4616 = new Municipio(null, "São Domingos do Norte", uf8);
		Municipio mun4656 = new Municipio(null, "São Gabriel da Palha", uf8);
		Municipio mun4763 = new Municipio(null, "São José do Calçado", uf8);
		Municipio mun4826 = new Municipio(null, "São Mateus", uf8);
		Municipio mun4880 = new Municipio(null, "São Roque do Canaã", uf8);
		Municipio mun5009 = new Municipio(null, "Serra", uf8);
		Municipio mun5083 = new Municipio(null, "Sooretama", uf8);
		Municipio mun5426 = new Municipio(null, "Vargem Alta", uf8);
		Municipio mun5456 = new Municipio(null, "Venda Nova do Imigrante", uf8);
		Municipio mun5482 = new Municipio(null, "Viana", uf8);
		Municipio mun5507 = new Municipio(null, "Vila Pavão", uf8);
		Municipio mun5510 = new Municipio(null, "Vila Valério", uf8);
		Municipio mun5511 = new Municipio(null, "Vila Velha", uf8);
		Municipio mun5535 = new Municipio(null, "Vitória", uf8);

		municipioRepository.saveAll(Arrays.asList(mun1, mun55, mun79, mun103, mun112, mun165, mun226, mun277, 
			mun1112, mun1175, mun1301, mun1326, mun1335, mun1571, mun1606, mun1615, 
			mun1641, mun1872, mun1949, mun1976, mun2021, mun2086, mun2109, mun2122, 
			mun2136, mun2279, mun2309, mun2368, mun2406, mun2453, mun2495, mun2575, 
			mun2595, mun2740, mun2785, mun2905, mun2929, mun2945, mun2961, mun3065, 
			mun306, mun423, mun462, mun512, mun635, mun682, mun762, mun856, 
			mun3128, mun3206, mun3218, mun3220, mun3383, mun3554, mun3713, mun3813, 
			mun3865, mun3923, mun4021, mun4184, mun4227, mun4410, mun4430, mun4473, 
			mun4616, mun4656, mun4763, mun4826, mun4880, mun5009, mun5083, mun5426, 
			mun5456, mun5482, mun5507, mun5510, mun5511, mun5535));

	}
	
	private void instanciaMunUf9(UF uf9) {
		Municipio mun2 = new Municipio(null, "Abadia de Goiás", uf9);
		Municipio mun4 = new Municipio(null, "Abadiânia", uf9);
		Municipio mun29 = new Municipio(null, "Acreúna", uf9);
		Municipio mun33 = new Municipio(null, "Adelândia", uf9);
		Municipio mun57 = new Municipio(null, "Água Fria de Goiás", uf9);
		Municipio mun59 = new Municipio(null, "Água Limpa", uf9);
		Municipio mun73 = new Municipio(null, "Águas Lindas de Goiás", uf9);
		Municipio mun110 = new Municipio(null, "Alexânia", uf9);
		Municipio mun127 = new Municipio(null, "Aloândia", uf9);
		Municipio mun154 = new Municipio(null, "Alto Horizonte", uf9);
		Municipio mun158 = new Municipio(null, "Alto Paraíso de Goiás", uf9);
		Municipio mun181 = new Municipio(null, "Alvorada do Norte", uf9);
		Municipio mun192 = new Municipio(null, "Amaralina", uf9);
		Municipio mun200 = new Municipio(null, "Americano do Brasil", uf9);
		Municipio mun205 = new Municipio(null, "Amorinópolis", uf9);
		Municipio mun220 = new Municipio(null, "Anápolis", uf9);
		Municipio mun246 = new Municipio(null, "Anhanguera", uf9);
		Municipio mun249 = new Municipio(null, "Anicuns", uf9);
		Municipio mun270 = new Municipio(null, "Aparecida de Goiânia", uf9);
		Municipio mun271 = new Municipio(null, "Aparecida do Rio Doce", uf9);
		Municipio mun284 = new Municipio(null, "Aporé", uf9);
		Municipio mun307 = new Municipio(null, "Araçu", uf9);
		Municipio mun309 = new Municipio(null, "Aragarças", uf9);
		Municipio mun310 = new Municipio(null, "Aragoiânia", uf9);
		Municipio mun319 = new Municipio(null, "Araguapaz", uf9);
		Municipio mun376 = new Municipio(null, "Arenópolis", uf9);
		Municipio mun402 = new Municipio(null, "Aruanã", uf9);
		Municipio mun432 = new Municipio(null, "Aurilândia", uf9);
		Municipio mun443 = new Municipio(null, "Avelinópolis", uf9);
		Municipio mun465 = new Municipio(null, "Baliza", uf9);
		Municipio mun548 = new Municipio(null, "Barro Alto", uf9);
		Municipio mun571 = new Municipio(null, "Bela Vista de Goiás", uf9);
		Municipio mun668 = new Municipio(null, "Bom Jardim de Goiás", uf9);
		Municipio mun677 = new Municipio(null, "Bom Jesus de Goiás", uf9);
		Municipio mun710 = new Municipio(null, "Bonfinópolis", uf9);
		Municipio mun718 = new Municipio(null, "Bonópolis", uf9);
		Municipio mun760 = new Municipio(null, "Brazabrantes", uf9);
		Municipio mun780 = new Municipio(null, "Britânia", uf9);
		Municipio mun799 = new Municipio(null, "Buriti Alegre", uf9);
		Municipio mun801 = new Municipio(null, "Buriti de Goiás", uf9);
		Municipio mun807 = new Municipio(null, "Buritinópolis", uf9);
		Municipio mun823 = new Municipio(null, "Cabeceiras", uf9);
		Municipio mun838 = new Municipio(null, "Cachoeira Alta", uf9);
		Municipio mun840 = new Municipio(null, "Cachoeira de Goiás", uf9);
		Municipio mun848 = new Municipio(null, "Cachoeira Dourada", uf9);
		Municipio mun864 = new Municipio(null, "Caçu", uf9);
		Municipio mun879 = new Municipio(null, "Caiapônia", uf9);
		Municipio mun905 = new Municipio(null, "Caldas Novas", uf9);
		Municipio mun907 = new Municipio(null, "Caldazinha", uf9);
		Municipio mun937 = new Municipio(null, "Campestre de Goiás", uf9);
		Municipio mun948 = new Municipio(null, "Campinaçu", uf9);
		Municipio mun953 = new Municipio(null, "Campinorte", uf9);
		Municipio mun954 = new Municipio(null, "Campo Alegre de Goiás", uf9);
		Municipio mun976 = new Municipio(null, "Campo Limpo de Goiás", uf9);
		Municipio mun987 = new Municipio(null, "Campos Belos", uf9);
		Municipio mun997 = new Municipio(null, "Campos Verdes", uf9);
		Municipio mun1133 = new Municipio(null, "Carmo do Rio Verde", uf9);
		Municipio mun1173 = new Municipio(null, "Castelândia", uf9);
		Municipio mun1180 = new Municipio(null, "Catalão", uf9);
		Municipio mun1196 = new Municipio(null, "Caturaí", uf9);
		Municipio mun1201 = new Municipio(null, "Cavalcante", uf9);
		Municipio mun1225 = new Municipio(null, "Ceres", uf9);
		Municipio mun1238 = new Municipio(null, "Cezarina", uf9);
		Municipio mun1250 = new Municipio(null, "Chapadão do Céu", uf9);
		Municipio mun1273 = new Municipio(null, "Cidade Ocidental", uf9);
		Municipio mun1292 = new Municipio(null, "Cocalzinho de Goiás", uf9);
		Municipio mun1304 = new Municipio(null, "Colinas do Sul", uf9);
		Municipio mun1415 = new Municipio(null, "Córrego do Ouro", uf9);
		Municipio mun1423 = new Municipio(null, "Corumbá de Goiás", uf9);
		Municipio mun1425 = new Municipio(null, "Corumbaíba", uf9);
		Municipio mun1460 = new Municipio(null, "Cristalina", uf9);
		Municipio mun1462 = new Municipio(null, "Cristianópolis", uf9);
		Municipio mun1468 = new Municipio(null, "Crixás", uf9);
		Municipio mun1470 = new Municipio(null, "Cromínia", uf9);
		Municipio mun1496 = new Municipio(null, "Cumari", uf9);
		Municipio mun1527 = new Municipio(null, "Damianópolis", uf9);
		Municipio mun1529 = new Municipio(null, "Damolândia", uf9);
		Municipio mun1535 = new Municipio(null, "Davinópolis", uf9);
		Municipio mun1565 = new Municipio(null, "Diorama", uf9);
		Municipio mun1575 = new Municipio(null, "Divinópolis de Goiás", uf9);
		Municipio mun1630 = new Municipio(null, "Doverlândia", uf9);
		Municipio mun1642 = new Municipio(null, "Edealina", uf9);
		Municipio mun1643 = new Municipio(null, "Edéia", uf9);
		Municipio mun1722 = new Municipio(null, "Estrela do Norte", uf9);
		Municipio mun1738 = new Municipio(null, "Faina", uf9);
		Municipio mun1754 = new Municipio(null, "Fazenda Nova", uf9);
		Municipio mun1792 = new Municipio(null, "Firminópolis", uf9);
		Municipio mun1801 = new Municipio(null, "Flores de Goiás", uf9);
		Municipio mun1825 = new Municipio(null, "Formosa", uf9);
		Municipio mun1828 = new Municipio(null, "Formoso", uf9);
		Municipio mun1880 = new Municipio(null, "Gameleira de Goiás", uf9);
		Municipio mun1924 = new Municipio(null, "Goianápolis", uf9);
		Municipio mun1925 = new Municipio(null, "Goiandira", uf9);
		Municipio mun1927 = new Municipio(null, "Goianésia", uf9);
		Municipio mun1928 = new Municipio(null, "Goiânia", uf9);
		Municipio mun1930 = new Municipio(null, "Goianira", uf9);
		Municipio mun1932 = new Municipio(null, "Goiás", uf9);
		Municipio mun1934 = new Municipio(null, "Goiatuba", uf9);
		Municipio mun1942 = new Municipio(null, "Gouvelândia", uf9);
		Municipio mun1997 = new Municipio(null, "Guapó", uf9);
		Municipio mun2010 = new Municipio(null, "Guaraíta", uf9);
		Municipio mun2016 = new Municipio(null, "Guarani de Goiás", uf9);
		Municipio mun2034 = new Municipio(null, "Guarinos", uf9);
		Municipio mun2054 = new Municipio(null, "Heitoraí", uf9);
		Municipio mun2062 = new Municipio(null, "Hidrolândia", uf9);
		Municipio mun2063 = new Municipio(null, "Hidrolina", uf9);
		Municipio mun2075 = new Municipio(null, "Iaciara", uf9);
		Municipio mun2187 = new Municipio(null, "Inaciolândia", uf9);
		Municipio mun2200 = new Municipio(null, "Indiara", uf9);
		Municipio mun2213 = new Municipio(null, "Inhumas", uf9);
		Municipio mun2219 = new Municipio(null, "Ipameri", uf9);
		Municipio mun2235 = new Municipio(null, "Ipiranga de Goiás", uf9);
		Municipio mun2245 = new Municipio(null, "Iporá", uf9);
		Municipio mun2281 = new Municipio(null, "Israelândia", uf9);
		Municipio mun2290 = new Municipio(null, "Itaberaí", uf9);
		Municipio mun2313 = new Municipio(null, "Itaguari", uf9);
		Municipio mun2314 = new Municipio(null, "Itaguaru", uf9);
		Municipio mun2327 = new Municipio(null, "Itajá", uf9);
		Municipio mun2357 = new Municipio(null, "Itapaci", uf9);
		Municipio mun2383 = new Municipio(null, "Itapirapuã", uf9);
		Municipio mun2400 = new Municipio(null, "Itapuranga", uf9);
		Municipio mun2411 = new Municipio(null, "Itarumã", uf9);
		Municipio mun2425 = new Municipio(null, "Itauçu", uf9);
		Municipio mun2444 = new Municipio(null, "Itumbiara", uf9);
		Municipio mun2459 = new Municipio(null, "Ivolândia", uf9);
		Municipio mun2512 = new Municipio(null, "Jandaia", uf9);
		Municipio mun2535 = new Municipio(null, "Jaraguá", uf9);
		Municipio mun2551 = new Municipio(null, "Jataí", uf9);
		Municipio mun2561 = new Municipio(null, "Jaupaci", uf9);
		Municipio mun2579 = new Municipio(null, "Jesúpolis", uf9);
		Municipio mun2617 = new Municipio(null, "Joviânia", uf9);
		Municipio mun2661 = new Municipio(null, "Jussara", uf9);
		Municipio mun2710 = new Municipio(null, "Lagoa Santa", uf9);
		Municipio mun2766 = new Municipio(null, "Leopoldo de Bulhões", uf9);
		Municipio mun2823 = new Municipio(null, "Luziânia", uf9);
		Municipio mun2864 = new Municipio(null, "Mairipotaba", uf9);
		Municipio mun2877 = new Municipio(null, "Mambaí", uf9);
		Municipio mun2909 = new Municipio(null, "Mara Rosa", uf9);
		Municipio mun2985 = new Municipio(null, "Marzagão", uf9);
		Municipio mun3021 = new Municipio(null, "Matrinchã", uf9);
		Municipio mun3030 = new Municipio(null, "Maurilândia", uf9);
		Municipio mun3064 = new Municipio(null, "Mimoso de Goiás", uf9);
		Municipio mun3066 = new Municipio(null, "Minaçu", uf9);
		Municipio mun3072 = new Municipio(null, "Mineiros", uf9);
		Municipio mun3111 = new Municipio(null, "Moiporá", uf9);
		Municipio mun3131 = new Municipio(null, "Monte Alegre de Goiás", uf9);
		Municipio mun3164 = new Municipio(null, "Montes Claros de Goiás", uf9);
		Municipio mun3167 = new Municipio(null, "Montividiu do Norte", uf9);
		Municipio mun3168 = new Municipio(null, "Montividiu", uf9);
		Municipio mun3180 = new Municipio(null, "Morrinhos", uf9);
		Municipio mun3181 = new Municipio(null, "Morro Agudo de Goiás", uf9);
		Municipio mun3195 = new Municipio(null, "Mossâmedes", uf9);
		Municipio mun3199 = new Municipio(null, "Mozarlândia", uf9);
		Municipio mun3214 = new Municipio(null, "Mundo Novo", uf9);
		Municipio mun3230 = new Municipio(null, "Mutunópolis", uf9);
		Municipio mun3254 = new Municipio(null, "Nazário", uf9);
		Municipio mun3257 = new Municipio(null, "Nerópolis", uf9);
		Municipio mun3268 = new Municipio(null, "Niquelândia", uf9);
		Municipio mun3290 = new Municipio(null, "Nova América", uf9);
		Municipio mun3294 = new Municipio(null, "Nova Aurora", uf9);
		Municipio mun3310 = new Municipio(null, "Nova Crixás", uf9);
		Municipio mun3323 = new Municipio(null, "Nova Glória", uf9);
		Municipio mun3329 = new Municipio(null, "Nova Iguaçu de Goiás", uf9);
		Municipio mun3367 = new Municipio(null, "Nova Roma", uf9);
		Municipio mun3385 = new Municipio(null, "Nova Veneza", uf9);
		Municipio mun3394 = new Municipio(null, "Novo Brasil", uf9);
		Municipio mun3397 = new Municipio(null, "Novo Gama", uf9);
		Municipio mun3413 = new Municipio(null, "Novo Planalto", uf9);
		Municipio mun3458 = new Municipio(null, "Orizona", uf9);
		Municipio mun3483 = new Municipio(null, "Ouro Verde de Goiás", uf9);
		Municipio mun3491 = new Municipio(null, "Ouvidor", uf9);
		Municipio mun3501 = new Municipio(null, "Padre Bernardo", uf9);
		Municipio mun3515 = new Municipio(null, "Palestina de Goiás", uf9);
		Municipio mun3539 = new Municipio(null, "Palmeiras de Goiás", uf9);
		Municipio mun3544 = new Municipio(null, "Palmelo", uf9);
		Municipio mun3545 = new Municipio(null, "Palminópolis", uf9);
		Municipio mun3552 = new Municipio(null, "Panamá", uf9);
		Municipio mun3588 = new Municipio(null, "Paranaiguara", uf9);
		Municipio mun3604 = new Municipio(null, "Paraúna", uf9);
		Municipio mun3752 = new Municipio(null, "Perolândia", uf9);
		Municipio mun3758 = new Municipio(null, "Petrolina de Goiás", uf9);
		Municipio mun3778 = new Municipio(null, "Pilar de Goiás", uf9);
		Municipio mun3822 = new Municipio(null, "Piracanjuba", uf9);
		Municipio mun3838 = new Municipio(null, "Piranhas", uf9);
		Municipio mun3852 = new Municipio(null, "Pirenópolis", uf9);
		Municipio mun3853 = new Municipio(null, "Pires do Rio", uf9);
		Municipio mun3870 = new Municipio(null, "Planaltina", uf9);
		Municipio mun3910 = new Municipio(null, "Pontalina", uf9);
		Municipio mun3930 = new Municipio(null, "Porangatu", uf9);
		Municipio mun3935 = new Municipio(null, "Porteirão", uf9);
		Municipio mun3939 = new Municipio(null, "Portelândia", uf9);
		Municipio mun3977 = new Municipio(null, "Posse", uf9);
		Municipio mun4041 = new Municipio(null, "Professor Jamil", uf9);
		Municipio mun4081 = new Municipio(null, "Quirinópolis", uf9);
		Municipio mun4153 = new Municipio(null, "Rialma", uf9);
		Municipio mun4154 = new Municipio(null, "Rianápolis", uf9);
		Municipio mun4236 = new Municipio(null, "Rio Quente", uf9);
		Municipio mun4242 = new Municipio(null, "Rio Verde", uf9);
		Municipio mun4284 = new Municipio(null, "Rubiataba", uf9);
		Municipio mun4335 = new Municipio(null, "Sanclerlândia", uf9);
		Municipio mun4344 = new Municipio(null, "Santa Bárbara de Goiás", uf9);
		Municipio mun4367 = new Municipio(null, "Santa Cruz de Goiás", uf9);
		Municipio mun4384 = new Municipio(null, "Santa Fé de Goiás", uf9);
		Municipio mun4393 = new Municipio(null, "Santa Helena de Goiás", uf9);
		Municipio mun4407 = new Municipio(null, "Santa Isabel", uf9);
		Municipio mun4452 = new Municipio(null, "Santa Rita do Araguaia", uf9);
		Municipio mun4454 = new Municipio(null, "Santa Rita do Novo Destino", uf9);
		Municipio mun4463 = new Municipio(null, "Santa Rosa de Goiás", uf9);
		Municipio mun4476 = new Municipio(null, "Santa Tereza de Goiás", uf9);
		Municipio mun4480 = new Municipio(null, "Santa Terezinha de Goiás", uf9);
		Municipio mun4535 = new Municipio(null, "Santo Antônio da Barra", uf9);
		Municipio mun4539 = new Municipio(null, "Santo Antônio de Goiás", uf9);
		Municipio mun4548 = new Municipio(null, "Santo Antônio do Descoberto", uf9);
		Municipio mun4622 = new Municipio(null, "São Domingos", uf9);
		Municipio mun4637 = new Municipio(null, "São Francisco de Goiás", uf9);
		Municipio mun4681 = new Municipio(null, "São João d'Aliança", uf9);
		Municipio mun4689 = new Municipio(null, "São João da Paraúna", uf9);
		Municipio mun4807 = new Municipio(null, "São Luís de Montes Belos", uf9);
		Municipio mun4814 = new Municipio(null, "São Luíz do Norte", uf9);
		Municipio mun4835 = new Municipio(null, "São Miguel do Araguaia", uf9);
		Municipio mun4842 = new Municipio(null, "São Miguel do Passa Quatro", uf9);
		Municipio mun4849 = new Municipio(null, "São Patrício", uf9);
		Municipio mun4905 = new Municipio(null, "São Simão", uf9);
		Municipio mun4961 = new Municipio(null, "Senador Canedo", uf9);
		Municipio mun5015 = new Municipio(null, "Serranópolis", uf9);
		Municipio mun5043 = new Municipio(null, "Silvânia", uf9);
		Municipio mun5054 = new Municipio(null, "Simolândia", uf9);
		Municipio mun5062 = new Municipio(null, "Sítio d'Abadia", uf9);
		Municipio mun5161 = new Municipio(null, "Taquaral de Goiás", uf9);
		Municipio mun5204 = new Municipio(null, "Teresina de Goiás", uf9);
		Municipio mun5208 = new Municipio(null, "Terezópolis de Goiás", uf9);
		Municipio mun5287 = new Municipio(null, "Três Ranchos", uf9);
		Municipio mun5294 = new Municipio(null, "Trindade", uf9);
		Municipio mun5300 = new Municipio(null, "Trombas", uf9);
		Municipio mun5334 = new Municipio(null, "Turvânia", uf9);
		Municipio mun5335 = new Municipio(null, "Turvelândia", uf9);
		Municipio mun5359 = new Municipio(null, "Uirapuru", uf9);
		Municipio mun5388 = new Municipio(null, "Uruaçu", uf9);
		Municipio mun5390 = new Municipio(null, "Uruana", uf9);
		Municipio mun5406 = new Municipio(null, "Urutaí", uf9);
		Municipio mun5421 = new Municipio(null, "Valparaíso de Goiás", uf9);
		Municipio mun5437 = new Municipio(null, "Varjão", uf9);
		Municipio mun5483 = new Municipio(null, "Vianópolis", uf9);
		Municipio mun5487 = new Municipio(null, "Vicentinópolis", uf9);
		Municipio mun5499 = new Municipio(null, "Vila Boa", uf9);
		Municipio mun5508 = new Municipio(null, "Vila Propício", uf9);

		municipioRepository.saveAll(Arrays.asList(mun1133, mun1173, mun1180, mun1196, mun1201, mun1225, mun1238, mun1250, 
			mun127, mun154, mun158, mun181, mun192, mun200, mun205, mun220, 
			mun1273, mun1292, mun1304, mun1415, mun1423, mun1425, mun1460, mun1462, 
			mun1468, mun1470, mun1496, mun1527, mun1529, mun1535, mun1565, mun1575, 
			mun1630, mun1642, mun1643, mun1722, mun1738, mun1754, mun1792, mun1801, 
			mun1825, mun1828, mun1880, mun1924, mun1925, mun1927, mun1928, mun1930, 
			mun1932, mun1934, mun1942, mun1997, mun2010, mun2016, mun2034, mun2054, 
			mun2, mun4, mun29, mun33, mun57, mun59, mun73, mun110, 
			mun2062, mun2063, mun2075, mun2187, mun2200, mun2213, mun2219, mun2235, 
			mun2245, mun2281, mun2290, mun2313, mun2314, mun2327, mun2357, mun2383, 
			mun2400, mun2411, mun2425, mun2444, mun2459, mun2512, mun2535, mun2551, 
			mun246, mun249, mun270, mun271, mun284, mun307, mun309, mun310, 
			mun2561, mun2579, mun2617, mun2661, mun2710, mun2766, mun2823, mun2864, 
			mun2877, mun2909, mun2985, mun3021, mun3030, mun3064, mun3066, mun3072, 
			mun3111, mun3131, mun3164, mun3167, mun3168, mun3180, mun3181, mun3195, 
			mun319, mun376, mun402, mun432, mun443, mun465, mun548, mun571, 
			mun3199, mun3214, mun3230, mun3254, mun3257, mun3268, mun3290, mun3294, 
			mun3310, mun3323, mun3329, mun3367, mun3385, mun3394, mun3397, mun3413, 
			mun3458, mun3483, mun3491, mun3501, mun3515, mun3539, mun3544, mun3545, 
			mun3552, mun3588, mun3604, mun3752, mun3758, mun3778, mun3822, mun3838, 
			mun3852, mun3853, mun3870, mun3910, mun3930, mun3935, mun3939, mun3977, 
			mun4041, mun4081, mun4153, mun4154, mun4236, mun4242, mun4284, mun4335, 
			mun4344, mun4367, mun4384, mun4393, mun4407, mun4452, mun4454, mun4463, 
			mun4476, mun4480, mun4535, mun4539, mun4548, mun4622, mun4637, mun4681, 
			mun4689, mun4807, mun4814, mun4835, mun4842, mun4849, mun4905, mun4961, 
			mun5015, mun5043, mun5054, mun5062, mun5161, mun5204, mun5208, mun5287, 
			mun5294, mun5300, mun5334, mun5335, mun5359, mun5388, mun5390, mun5406, 
			mun5421, mun5437, mun5483, mun5487, mun5499, mun5508, 
			mun668, mun677, mun710, mun718, mun760, mun780, mun799, mun801, 
			mun807, mun823, mun838, mun840, mun848, mun864, mun879, mun905, 
			mun907, mun937, mun948, mun953, mun954, mun976, mun987, mun997));

	}
	
	private void instanciaMunUf10(UF uf10) {
		Municipio mun18 = new Municipio(null, "Açailândia", uf10);
		Municipio mun39 = new Municipio(null, "Afonso Cunha", uf10);
		Municipio mun54 = new Municipio(null, "Água Doce do Maranhão", uf10);
		Municipio mun96 = new Municipio(null, "Alcântara", uf10);
		Municipio mun101 = new Municipio(null, "Aldeias Altas", uf10);
		Municipio mun134 = new Municipio(null, "Altamira do Maranhão", uf10);
		Municipio mun141 = new Municipio(null, "Alto Alegre do Maranhão", uf10);
		Municipio mun142 = new Municipio(null, "Alto Alegre do Pindaré", uf10);
		Municipio mun162 = new Municipio(null, "Alto Parnaíba", uf10);
		Municipio mun187 = new Municipio(null, "Amapá do Maranhão", uf10);
		Municipio mun193 = new Municipio(null, "Amarante do Maranhão", uf10);
		Municipio mun215 = new Municipio(null, "Anajatuba", uf10);
		Municipio mun222 = new Municipio(null, "Anapurus", uf10);
		Municipio mun280 = new Municipio(null, "Apicum-Açu", uf10);
		Municipio mun317 = new Municipio(null, "Araguanã", uf10);
		Municipio mun322 = new Municipio(null, "Araioses", uf10);
		Municipio mun326 = new Municipio(null, "Arame", uf10);
		Municipio mun346 = new Municipio(null, "Arari", uf10);
		Municipio mun445 = new Municipio(null, "Axixá", uf10);
		Municipio mun447 = new Municipio(null, "Bacabal", uf10);
		Municipio mun448 = new Municipio(null, "Bacabeira", uf10);
		Municipio mun449 = new Municipio(null, "Bacuri", uf10);
		Municipio mun450 = new Municipio(null, "Bacurituba", uf10);
		Municipio mun473 = new Municipio(null, "Balsas", uf10);
		Municipio mun489 = new Municipio(null, "Barão de Grajaú", uf10);
		Municipio mun518 = new Municipio(null, "Barra do Corda", uf10);
		Municipio mun543 = new Municipio(null, "Barreirinhas", uf10);
		Municipio mun573 = new Municipio(null, "Bela Vista do Maranhão", uf10);
		Municipio mun578 = new Municipio(null, "Belágua", uf10);
		Municipio mun598 = new Municipio(null, "Benedito Leite", uf10);
		Municipio mun606 = new Municipio(null, "Bequimão", uf10);
		Municipio mun611 = new Municipio(null, "Bernardo do Mearim", uf10);
		Municipio mun645 = new Municipio(null, "Boa Vista do Gurupi", uf10);
		Municipio mun670 = new Municipio(null, "Bom Jardim", uf10);
		Municipio mun676 = new Municipio(null, "Bom Jesus das Selvas", uf10);
		Municipio mun693 = new Municipio(null, "Bom Lugar", uf10);
		Municipio mun768 = new Municipio(null, "Brejo de Areia", uf10);
		Municipio mun775 = new Municipio(null, "Brejo", uf10);
		Municipio mun800 = new Municipio(null, "Buriti Bravo", uf10);
		Municipio mun805 = new Municipio(null, "Buriti", uf10);
		Municipio mun806 = new Municipio(null, "Buriticupu", uf10);
		Municipio mun809 = new Municipio(null, "Buritirana", uf10);
		Municipio mun849 = new Municipio(null, "Cachoeira Grande", uf10);
		Municipio mun891 = new Municipio(null, "Cajapió", uf10);
		Municipio mun892 = new Municipio(null, "Cajari", uf10);
		Municipio mun938 = new Municipio(null, "Campestre do Maranhão", uf10);
		Municipio mun1020 = new Municipio(null, "Cândido Mendes", uf10);
		Municipio mun1042 = new Municipio(null, "Cantanhede", uf10);
		Municipio mun1068 = new Municipio(null, "Capinzal do Norte", uf10);
		Municipio mun1146 = new Municipio(null, "Carolina", uf10);
		Municipio mun1152 = new Municipio(null, "Carutapera", uf10);
		Municipio mun1205 = new Municipio(null, "Caxias", uf10);
		Municipio mun1208 = new Municipio(null, "Cedral", uf10);
		Municipio mun1219 = new Municipio(null, "Central do Maranhão", uf10);
		Municipio mun1222 = new Municipio(null, "Centro do Guilherme", uf10);
		Municipio mun1223 = new Municipio(null, "Centro Novo do Maranhão", uf10);
		Municipio mun1253 = new Municipio(null, "Chapadinha", uf10);
		Municipio mun1274 = new Municipio(null, "Cidelândia", uf10);
		Municipio mun1295 = new Municipio(null, "Codó", uf10);
		Municipio mun1296 = new Municipio(null, "Coelho Neto", uf10);
		Municipio mun1306 = new Municipio(null, "Colinas", uf10);
		Municipio mun1338 = new Municipio(null, "Conceição do Lago-Açu", uf10);
		Municipio mun1394 = new Municipio(null, "Coroatá", uf10);
		Municipio mun1521 = new Municipio(null, "Cururupu", uf10);
		Municipio mun1534 = new Municipio(null, "Davinópolis", uf10);
		Municipio mun1603 = new Municipio(null, "Dom Pedro", uf10);
		Municipio mun1637 = new Municipio(null, "Duque Bacelar", uf10);
		Municipio mun1700 = new Municipio(null, "Esperantinópolis", uf10);
		Municipio mun1716 = new Municipio(null, "Estreito", uf10);
		Municipio mun1761 = new Municipio(null, "Feira Nova do Maranhão", uf10);
		Municipio mun1775 = new Municipio(null, "Fernando Falcão", uf10);
		Municipio mun1821 = new Municipio(null, "Formosa da Serra Negra", uf10);
		Municipio mun1834 = new Municipio(null, "Fortaleza dos Nogueiras", uf10);
		Municipio mun1839 = new Municipio(null, "Fortuna", uf10);
		Municipio mun1919 = new Municipio(null, "Godofredo Viana", uf10);
		Municipio mun1937 = new Municipio(null, "Gonçalves Dias", uf10);
		Municipio mun1943 = new Municipio(null, "Governador Archer", uf10);
		Municipio mun1946 = new Municipio(null, "Governador Edison Lobão", uf10);
		Municipio mun1947 = new Municipio(null, "Governador Eugênio Barros", uf10);
		Municipio mun1950 = new Municipio(null, "Governador Luiz Rocha", uf10);
		Municipio mun1952 = new Municipio(null, "Governador Newton Bello", uf10);
		Municipio mun1953 = new Municipio(null, "Governador Nunes Freire", uf10);
		Municipio mun1955 = new Municipio(null, "Graça Aranha", uf10);
		Municipio mun1958 = new Municipio(null, "Grajaú", uf10);
		Municipio mun2043 = new Municipio(null, "Guimarães", uf10);
		Municipio mun2073 = new Municipio(null, "Humberto de Campos", uf10);
		Municipio mun2132 = new Municipio(null, "Icatu", uf10);
		Municipio mun2144 = new Municipio(null, "Igarapé do Meio", uf10);
		Municipio mun2145 = new Municipio(null, "Igarapé Grande", uf10);
		Municipio mun2185 = new Municipio(null, "Imperatriz", uf10);
		Municipio mun2321 = new Municipio(null, "Itaipava do Grajaú", uf10);
		Municipio mun2365 = new Municipio(null, "Itapecuru Mirim", uf10);
		Municipio mun2430 = new Municipio(null, "Itinga do Maranhão", uf10);
		Municipio mun2557 = new Municipio(null, "Jatobá", uf10);
		Municipio mun2565 = new Municipio(null, "Jenipapo dos Vieiras", uf10);
		Municipio mun2593 = new Municipio(null, "João Lisboa", uf10);
		Municipio mun2615 = new Municipio(null, "Joselândia", uf10);
		Municipio mun2636 = new Municipio(null, "Junco do Maranhão", uf10);
		Municipio mun2676 = new Municipio(null, "Lago da Pedra", uf10);
		Municipio mun2677 = new Municipio(null, "Lago do Junco", uf10);
		Municipio mun2678 = new Municipio(null, "Lago dos Rodrigues", uf10);
		Municipio mun2679 = new Municipio(null, "Lago Verde", uf10);
		Municipio mun2693 = new Municipio(null, "Lagoa do Mato", uf10);
		Municipio mun2703 = new Municipio(null, "Lagoa Grande do Maranhão", uf10);
		Municipio mun2723 = new Municipio(null, "Lajeado Novo", uf10);
		Municipio mun2772 = new Municipio(null, "Lima Campos", uf10);
		Municipio mun2797 = new Municipio(null, "Loreto", uf10);
		Municipio mun2808 = new Municipio(null, "Luís Domingues", uf10);
		Municipio mun2857 = new Municipio(null, "Magalhães de Almeida", uf10);
		Municipio mun2913 = new Municipio(null, "Maracaçumé", uf10);
		Municipio mun2923 = new Municipio(null, "Marajá do Sena", uf10);
		Municipio mun2925 = new Municipio(null, "Maranhãozinho", uf10);
		Municipio mun2993 = new Municipio(null, "Mata Roma", uf10);
		Municipio mun3007 = new Municipio(null, "Matinha", uf10);
		Municipio mun3017 = new Municipio(null, "Matões do Norte", uf10);
		Municipio mun3018 = new Municipio(null, "Matões", uf10);
		Municipio mun3059 = new Municipio(null, "Milagres do Maranhão", uf10);
		Municipio mun3079 = new Municipio(null, "Mirador", uf10);
		Municipio mun3085 = new Municipio(null, "Miranda do Norte", uf10);
		Municipio mun3100 = new Municipio(null, "Mirinzal", uf10);
		Municipio mun3117 = new Municipio(null, "Monção", uf10);
		Municipio mun3163 = new Municipio(null, "Montes Altos", uf10);
		Municipio mun3192 = new Municipio(null, "Morros", uf10);
		Municipio mun3264 = new Municipio(null, "Nina Rodrigues", uf10);
		Municipio mun3309 = new Municipio(null, "Nova Colinas", uf10);
		Municipio mun3332 = new Municipio(null, "Nova Iorque", uf10);
		Municipio mun3350 = new Municipio(null, "Nova Olinda do Maranhão", uf10);
		Municipio mun3432 = new Municipio(null, "Olho d'Água das Cunhãs", uf10);
		Municipio mun3442 = new Municipio(null, "Olinda Nova do Maranhão", uf10);
		Municipio mun3498 = new Municipio(null, "Paço do Lumiar", uf10);
		Municipio mun3537 = new Municipio(null, "Palmeirândia", uf10);
		Municipio mun3571 = new Municipio(null, "Paraibano", uf10);
		Municipio mun3620 = new Municipio(null, "Parnarama", uf10);
		Municipio mun3628 = new Municipio(null, "Passagem Franca", uf10);
		Municipio mun3639 = new Municipio(null, "Pastos Bons", uf10);
		Municipio mun3662 = new Municipio(null, "Paulino Neves", uf10);
		Municipio mun3674 = new Municipio(null, "Paulo Ramos", uf10);
		Municipio mun3706 = new Municipio(null, "Pedreiras", uf10);
		Municipio mun3715 = new Municipio(null, "Pedro do Rosário", uf10);
		Municipio mun3730 = new Municipio(null, "Penalva", uf10);
		Municipio mun3745 = new Municipio(null, "Peri Mirim", uf10);
		Municipio mun3748 = new Municipio(null, "Peritoró", uf10);
		Municipio mun3791 = new Municipio(null, "Pindaré-Mirim", uf10);
		Municipio mun3812 = new Municipio(null, "Pinheiro", uf10);
		Municipio mun3817 = new Municipio(null, "Pio XII", uf10);
		Municipio mun3839 = new Municipio(null, "Pirapemas", uf10);
		Municipio mun3881 = new Municipio(null, "Poção de Pedras", uf10);
		Municipio mun3959 = new Municipio(null, "Porto Franco", uf10);
		Municipio mun3967 = new Municipio(null, "Porto Rico do Maranhão", uf10);
		Municipio mun4011 = new Municipio(null, "Presidente Dutra", uf10);
		Municipio mun4017 = new Municipio(null, "Presidente Juscelino", uf10);
		Municipio mun4024 = new Municipio(null, "Presidente Médici", uf10);
		Municipio mun4029 = new Municipio(null, "Presidente Sarney", uf10);
		Municipio mun4031 = new Municipio(null, "Presidente Vargas", uf10);
		Municipio mun4037 = new Municipio(null, "Primeira Cruz", uf10);
		Municipio mun4101 = new Municipio(null, "Raposa", uf10);
		Municipio mun4139 = new Municipio(null, "Riachão", uf10);
		Municipio mun4155 = new Municipio(null, "Ribamar Fiquene", uf10);
		Municipio mun4279 = new Municipio(null, "Rosário", uf10);
		Municipio mun4332 = new Municipio(null, "Sambaíba", uf10);
		Municipio mun4389 = new Municipio(null, "Santa Filomena do Maranhão", uf10);
		Municipio mun4395 = new Municipio(null, "Santa Helena", uf10);
		Municipio mun4399 = new Municipio(null, "Santa Inês", uf10);
		Municipio mun4418 = new Municipio(null, "Santa Luzia do Paruá", uf10);
		Municipio mun4419 = new Municipio(null, "Santa Luzia", uf10);
		Municipio mun4444 = new Municipio(null, "Santa Quitéria do Maranhão", uf10);
		Municipio mun4460 = new Municipio(null, "Santa Rita", uf10);
		Municipio mun4507 = new Municipio(null, "Santana do Maranhão", uf10);
		Municipio mun4528 = new Municipio(null, "Santo Amaro do Maranhão", uf10);
		Municipio mun4565 = new Municipio(null, "Santo Antônio dos Lopes", uf10);
		Municipio mun4579 = new Municipio(null, "São Benedito do Rio Preto", uf10);
		Municipio mun4590 = new Municipio(null, "São Bento", uf10);
		Municipio mun4594 = new Municipio(null, "São Bernardo", uf10);
		Municipio mun4612 = new Municipio(null, "São Domingos do Azeitão", uf10);
		Municipio mun4615 = new Municipio(null, "São Domingos do Maranhão", uf10);
		Municipio mun4625 = new Municipio(null, "São Félix de Balsas", uf10);
		Municipio mun4642 = new Municipio(null, "São Francisco do Brejão", uf10);
		Municipio mun4646 = new Municipio(null, "São Francisco do Maranhão", uf10);
		Municipio mun4679 = new Municipio(null, "São João Batista", uf10);
		Municipio mun4705 = new Municipio(null, "São João do Carú", uf10);
		Municipio mun4714 = new Municipio(null, "São João do Paraíso", uf10);
		Municipio mun4721 = new Municipio(null, "São João do Soter", uf10);
		Municipio mun4725 = new Municipio(null, "São João dos Patos", uf10);
		Municipio mun4756 = new Municipio(null, "São José de Ribamar", uf10);
		Municipio mun4791 = new Municipio(null, "São José dos Basílios", uf10);
		Municipio mun4812 = new Municipio(null, "São Luís Gonzaga do Maranhão", uf10);
		Municipio mun4813 = new Municipio(null, "São Luís", uf10);
		Municipio mun4824 = new Municipio(null, "São Mateus do Maranhão", uf10);
		Municipio mun4854 = new Municipio(null, "São Pedro da Água Branca", uf10);
		Municipio mun4869 = new Municipio(null, "São Pedro dos Crentes", uf10);
		Municipio mun4874 = new Municipio(null, "São Raimundo das Mangabeiras", uf10);
		Municipio mun4875 = new Municipio(null, "São Raimundo do Doca Bezerra", uf10);
		Municipio mun4877 = new Municipio(null, "São Roberto", uf10);
		Municipio mun4918 = new Municipio(null, "São Vicente Ferrer", uf10);
		Municipio mun4940 = new Municipio(null, "Satubinha", uf10);
		Municipio mun4959 = new Municipio(null, "Senador Alexandre Costa", uf10);
		Municipio mun4969 = new Municipio(null, "Senador La Rocque", uf10);
		Municipio mun5012 = new Municipio(null, "Serrano do Maranhão", uf10);
		Municipio mun5066 = new Municipio(null, "Sítio Novo", uf10);
		Municipio mun5090 = new Municipio(null, "Sucupira do Norte", uf10);
		Municipio mun5091 = new Municipio(null, "Sucupira do Riachão", uf10);
		Municipio mun5177 = new Municipio(null, "Tasso Fragoso", uf10);
		Municipio mun5233 = new Municipio(null, "Timbiras", uf10);
		Municipio mun5237 = new Municipio(null, "Timon", uf10);
		Municipio mun5299 = new Municipio(null, "Trizidela do Vale", uf10);
		Municipio mun5307 = new Municipio(null, "Tufilândia", uf10);
		Municipio mun5314 = new Municipio(null, "Tuntum", uf10);
		Municipio mun5327 = new Municipio(null, "Turiaçu", uf10);
		Municipio mun5328 = new Municipio(null, "Turilândia", uf10);
		Municipio mun5339 = new Municipio(null, "Tutóia", uf10);
		Municipio mun5386 = new Municipio(null, "Urbano Santos", uf10);
		Municipio mun5432 = new Municipio(null, "Vargem Grande", uf10);
		Municipio mun5481 = new Municipio(null, "Viana", uf10);
		Municipio mun5506 = new Municipio(null, "Vila Nova dos Martírios", uf10);
		Municipio mun5533 = new Municipio(null, "Vitória do Mearim", uf10);
		Municipio mun5536 = new Municipio(null, "Vitorino Freire", uf10);
		Municipio mun5563 = new Municipio(null, "Zé Doca", uf10);

		municipioRepository.saveAll(Arrays.asList(mun1068, mun1146, mun1152, mun1205, mun1208, mun1219, mun1222, mun1223, 
			mun1253, mun1274, mun1295, mun1296, mun1306, mun1338, mun1394, mun1521, 
			mun1534, mun1603, mun1637, mun1700, mun1716, mun1761, mun1775, mun1821, 
			mun162, mun187, mun193, mun215, mun222, mun280, mun317, mun322, 
			mun18, mun39, mun54, mun96, mun101, mun134, mun141, mun142, 
			mun1834, mun1839, mun1919, mun1937, mun1943, mun1946, mun1947, mun1950, 
			mun1952, mun1953, mun1955, mun1958, mun2043, mun2073, mun2132, mun2144, 
			mun2145, mun2185, mun2321, mun2365, mun2430, mun2557, mun2565, mun2593, 
			mun2615, mun2636, mun2676, mun2677, mun2678, mun2679, mun2693, mun2703, 
			mun2723, mun2772, mun2797, mun2808, mun2857, mun2913, mun2923, mun2925, 
			mun2993, mun3007, mun3017, mun3018, mun3059, mun3079, mun3085, mun3100, 
			mun3117, mun3163, mun3192, mun3264, mun3309, mun3332, mun3350, mun3432, 
			mun326, mun346, mun445, mun447, mun448, mun449, mun450, mun473, 
			mun3442, mun3498, mun3537, mun3571, mun3620, mun3628, mun3639, mun3662, 
			mun3674, mun3706, mun3715, mun3730, mun3745, mun3748, mun3791, mun3812, 
			mun3817, mun3839, mun3881, mun3959, mun3967, mun4011, mun4017, mun4024, 
			mun4029, mun4031, mun4037, mun4101, mun4139, mun4155, mun4279, mun4332, 
			mun4389, mun4395, mun4399, mun4418, mun4419, mun4444, mun4460, mun4507, 
			mun4528, mun4565, mun4579, mun4590, mun4594, mun4612, mun4615, mun4625, 
			mun4642, mun4646, mun4679, mun4705, mun4714, mun4721, mun4725, mun4756, 
			mun4791, mun4812, mun4813, mun4824, mun4854, mun4869, mun4874, mun4875, 
			mun4877, mun4918, mun4940, mun4959, mun4969, mun5012, mun5066, mun5090, 
			mun489, mun518, mun543, mun573, mun578, mun598, mun606, mun611, 
			mun5091, mun5177, mun5233, mun5237, mun5299, mun5307, mun5314, mun5327, 
			mun5328, mun5339, mun5386, mun5432, mun5481, mun5506, mun5533, mun5536, 
			mun5563, 
			mun645, mun670, mun676, mun693, mun768, mun775, mun800, mun805, 
			mun806, mun809, mun849, mun891, mun892, mun938, mun1020, mun1042));

	}
	
	private void instanciaMunUf11(UF uf11) {
		Municipio mun3 = new Municipio(null, "Abadia dos Dourados", uf11);
		Municipio mun5 = new Municipio(null, "Abaeté", uf11);
		Municipio mun14 = new Municipio(null, "Abre Campo", uf11);
		Municipio mun17 = new Municipio(null, "Acaiaca", uf11);
		Municipio mun31 = new Municipio(null, "Açucena", uf11);
		Municipio mun47 = new Municipio(null, "Água Boa", uf11);
		Municipio mun53 = new Municipio(null, "Água Comprida", uf11);
		Municipio mun64 = new Municipio(null, "Aguanil", uf11);
		Municipio mun71 = new Municipio(null, "Águas Formosas", uf11);
		Municipio mun75 = new Municipio(null, "Águas Vermelhas", uf11);
		Municipio mun82 = new Municipio(null, "Aimorés", uf11);
		Municipio mun85 = new Municipio(null, "Aiuruoca", uf11);
		Municipio mun89 = new Municipio(null, "Alagoa", uf11);
		Municipio mun95 = new Municipio(null, "Albertina", uf11);
		Municipio mun107 = new Municipio(null, "Além Paraíba", uf11);
		Municipio mun111 = new Municipio(null, "Alfenas", uf11);
		Municipio mun114 = new Municipio(null, "Alfredo Vasconcelos", uf11);
		Municipio mun123 = new Municipio(null, "Almenara", uf11);
		Municipio mun128 = new Municipio(null, "Alpercata", uf11);
		Municipio mun130 = new Municipio(null, "Alpinópolis", uf11);
		Municipio mun138 = new Municipio(null, "Alterosa", uf11);
		Municipio mun150 = new Municipio(null, "Alto Caparaó", uf11);
		Municipio mun155 = new Municipio(null, "Alto Jequitibá", uf11);
		Municipio mun164 = new Municipio(null, "Alto Rio Doce", uf11);
		Municipio mun172 = new Municipio(null, "Alvarenga", uf11);
		Municipio mun177 = new Municipio(null, "Alvinópolis", uf11);
		Municipio mun179 = new Municipio(null, "Alvorada de Minas", uf11);
		Municipio mun207 = new Municipio(null, "Amparo do Serra", uf11);
		Municipio mun230 = new Municipio(null, "Andradas", uf11);
		Municipio mun233 = new Municipio(null, "Andrelândia", uf11);
		Municipio mun235 = new Municipio(null, "Angelândia", uf11);
		Municipio mun260 = new Municipio(null, "Antônio Carlos", uf11);
		Municipio mun262 = new Municipio(null, "Antônio Dias", uf11);
		Municipio mun267 = new Municipio(null, "Antônio Prado de Minas", uf11);
		Municipio mun294 = new Municipio(null, "Araçaí", uf11);
		Municipio mun302 = new Municipio(null, "Aracitaba", uf11);
		Municipio mun308 = new Municipio(null, "Araçuaí", uf11);
		Municipio mun320 = new Municipio(null, "Araguari", uf11);
		Municipio mun329 = new Municipio(null, "Arantina", uf11);
		Municipio mun333 = new Municipio(null, "Araponga", uf11);
		Municipio mun335 = new Municipio(null, "Araporã", uf11);
		Municipio mun337 = new Municipio(null, "Arapuá", uf11);
		Municipio mun359 = new Municipio(null, "Araújos", uf11);
		Municipio mun360 = new Municipio(null, "Araxá", uf11);
		Municipio mun361 = new Municipio(null, "Arceburgo", uf11);
		Municipio mun363 = new Municipio(null, "Arcos", uf11);
		Municipio mun365 = new Municipio(null, "Areado", uf11);
		Municipio mun378 = new Municipio(null, "Argirita", uf11);
		Municipio mun379 = new Municipio(null, "Aricanduva", uf11);
		Municipio mun380 = new Municipio(null, "Arinos", uf11);
		Municipio mun415 = new Municipio(null, "Astolfo Dutra", uf11);
		Municipio mun421 = new Municipio(null, "Ataléia", uf11);
		Municipio mun426 = new Municipio(null, "Augusto de Lima", uf11);
		Municipio mun452 = new Municipio(null, "Baependi", uf11);
		Municipio mun464 = new Municipio(null, "Baldim", uf11);
		Municipio mun474 = new Municipio(null, "Bambuí", uf11);
		Municipio mun478 = new Municipio(null, "Bandeira do Sul", uf11);
		Municipio mun479 = new Municipio(null, "Bandeira", uf11);
		Municipio mun487 = new Municipio(null, "Barão de Cocais", uf11);
		Municipio mun491 = new Municipio(null, "Barão de Monte Alto", uf11);
		Municipio mun496 = new Municipio(null, "Barbacena", uf11);
		Municipio mun532 = new Municipio(null, "Barra Longa", uf11);
		Municipio mun556 = new Municipio(null, "Barroso", uf11);
		Municipio mun572 = new Municipio(null, "Bela Vista de Minas", uf11);
		Municipio mun587 = new Municipio(null, "Belmiro Braga", uf11);
		Municipio mun591 = new Municipio(null, "Belo Horizonte", uf11);
		Municipio mun594 = new Municipio(null, "Belo Oriente", uf11);
		Municipio mun595 = new Municipio(null, "Belo Vale", uf11);
		Municipio mun607 = new Municipio(null, "Berilo", uf11);
		Municipio mun608 = new Municipio(null, "Berizal", uf11);
		Municipio mun615 = new Municipio(null, "Bertópolis", uf11);
		Municipio mun619 = new Municipio(null, "Betim", uf11);
		Municipio mun621 = new Municipio(null, "Bias Fortes", uf11);
		Municipio mun622 = new Municipio(null, "Bicas", uf11);
		Municipio mun625 = new Municipio(null, "Biquinhas", uf11);
		Municipio mun633 = new Municipio(null, "Boa Esperança", uf11);
		Municipio mun654 = new Municipio(null, "Bocaina de Minas", uf11);
		Municipio mun659 = new Municipio(null, "Bocaiúva", uf11);
		Municipio mun666 = new Municipio(null, "Bom Despacho", uf11);
		Municipio mun669 = new Municipio(null, "Bom Jardim de Minas", uf11);
		Municipio mun674 = new Municipio(null, "Bom Jesus da Penha", uf11);
		Municipio mun678 = new Municipio(null, "Bom Jesus do Amparo", uf11);
		Municipio mun680 = new Municipio(null, "Bom Jesus do Galho", uf11);
		Municipio mun697 = new Municipio(null, "Bom Repouso", uf11);
		Municipio mun702 = new Municipio(null, "Bom Sucesso", uf11);
		Municipio mun707 = new Municipio(null, "Bonfim", uf11);
		Municipio mun709 = new Municipio(null, "Bonfinópolis de Minas", uf11);
		Municipio mun712 = new Municipio(null, "Bonito de Minas", uf11);
		Municipio mun729 = new Municipio(null, "Borda da Mata", uf11);
		Municipio mun733 = new Municipio(null, "Botelhos", uf11);
		Municipio mun735 = new Municipio(null, "Botumirim", uf11);
		Municipio mun746 = new Municipio(null, "Brás Pires", uf11);
		Municipio mun748 = new Municipio(null, "Brasilândia de Minas", uf11);
		Municipio mun754 = new Municipio(null, "Brasília de Minas", uf11);
		Municipio mun757 = new Municipio(null, "Brasópolis", uf11);
		Municipio mun759 = new Municipio(null, "Braúnas", uf11);
		Municipio mun785 = new Municipio(null, "Brumadinho", uf11);
		Municipio mun789 = new Municipio(null, "Bueno Brandão", uf11);
		Municipio mun790 = new Municipio(null, "Buenópolis", uf11);
		Municipio mun793 = new Municipio(null, "Bugre", uf11);
		Municipio mun810 = new Municipio(null, "Buritis", uf11);
		Municipio mun813 = new Municipio(null, "Buritizeiro", uf11);
		Municipio mun821 = new Municipio(null, "Cabeceira Grande", uf11);
		Municipio mun828 = new Municipio(null, "Cabo Verde", uf11);
		Municipio mun839 = new Municipio(null, "Cachoeira da Prata", uf11);
		Municipio mun841 = new Municipio(null, "Cachoeira de Minas", uf11);
		Municipio mun842 = new Municipio(null, "Cachoeira de Pajeú", uf11);
		Municipio mun847 = new Municipio(null, "Cachoeira Dourada", uf11);
		Municipio mun867 = new Municipio(null, "Caetanópolis", uf11);
		Municipio mun869 = new Municipio(null, "Caeté", uf11);
		Municipio mun878 = new Municipio(null, "Caiana", uf11);
		Municipio mun900 = new Municipio(null, "Cajuri", uf11);
		Municipio mun906 = new Municipio(null, "Caldas", uf11);
		Municipio mun915 = new Municipio(null, "Camacho", uf11);
		Municipio mun918 = new Municipio(null, "Camanducaia", uf11);
		Municipio mun929 = new Municipio(null, "Cambuí", uf11);
		Municipio mun930 = new Municipio(null, "Cambuquira", uf11);
		Municipio mun934 = new Municipio(null, "Campanário", uf11);
		Municipio mun935 = new Municipio(null, "Campanha", uf11);
		Municipio mun939 = new Municipio(null, "Campestre", uf11);
		Municipio mun947 = new Municipio(null, "Campina Verde", uf11);
		Municipio mun959 = new Municipio(null, "Campo Azul", uf11);
		Municipio mun961 = new Municipio(null, "Campo Belo", uf11);
		Municipio mun966 = new Municipio(null, "Campo do Meio", uf11);
		Municipio mun969 = new Municipio(null, "Campo Florido", uf11);
		Municipio mun986 = new Municipio(null, "Campos Altos", uf11);
		Municipio mun992 = new Municipio(null, "Campos Gerais", uf11);
		Municipio mun999 = new Municipio(null, "Cana Verde", uf11);
		Municipio mun1001 = new Municipio(null, "Canaã", uf11);
		Municipio mun1005 = new Municipio(null, "Canápolis", uf11);
		Municipio mun1014 = new Municipio(null, "Candeias", uf11);
		Municipio mun1039 = new Municipio(null, "Cantagalo", uf11);
		Municipio mun1055 = new Municipio(null, "Caparaó", uf11);
		Municipio mun1059 = new Municipio(null, "Capela Nova", uf11);
		Municipio mun1062 = new Municipio(null, "Capelinha", uf11);
		Municipio mun1063 = new Municipio(null, "Capetinga", uf11);
		Municipio mun1064 = new Municipio(null, "Capim Branco", uf11);
		Municipio mun1067 = new Municipio(null, "Capinópolis", uf11);
		Municipio mun1071 = new Municipio(null, "Capitão Andrade", uf11);
		Municipio mun1073 = new Municipio(null, "Capitão Enéas", uf11);
		Municipio mun1078 = new Municipio(null, "Capitólio", uf11);
		Municipio mun1084 = new Municipio(null, "Caputira", uf11);
		Municipio mun1090 = new Municipio(null, "Caraí", uf11);
		Municipio mun1093 = new Municipio(null, "Caranaíba", uf11);
		Municipio mun1094 = new Municipio(null, "Carandaí", uf11);
		Municipio mun1095 = new Municipio(null, "Carangola", uf11);
		Municipio mun1098 = new Municipio(null, "Caratinga", uf11);
		Municipio mun1105 = new Municipio(null, "Carbonita", uf11);
		Municipio mun1109 = new Municipio(null, "Careaçu", uf11);
		Municipio mun1124 = new Municipio(null, "Carlos Chagas", uf11);
		Municipio mun1126 = new Municipio(null, "Carmésia", uf11);
		Municipio mun1127 = new Municipio(null, "Carmo da Cachoeira", uf11);
		Municipio mun1128 = new Municipio(null, "Carmo da Mata", uf11);
		Municipio mun1129 = new Municipio(null, "Carmo de Minas", uf11);
		Municipio mun1130 = new Municipio(null, "Carmo do Cajuru", uf11);
		Municipio mun1131 = new Municipio(null, "Carmo do Paranaíba", uf11);
		Municipio mun1132 = new Municipio(null, "Carmo do Rio Claro", uf11);
		Municipio mun1136 = new Municipio(null, "Carmópolis de Minas", uf11);
		Municipio mun1143 = new Municipio(null, "Carneirinho", uf11);
		Municipio mun1148 = new Municipio(null, "Carrancas", uf11);
		Municipio mun1153 = new Municipio(null, "Carvalhópolis", uf11);
		Municipio mun1154 = new Municipio(null, "Carvalhos", uf11);
		Municipio mun1156 = new Municipio(null, "Casa Grande", uf11);
		Municipio mun1159 = new Municipio(null, "Cascalho Rico", uf11);
		Municipio mun1168 = new Municipio(null, "Cássia", uf11);
		Municipio mun1179 = new Municipio(null, "Cataguases", uf11);
		Municipio mun1185 = new Municipio(null, "Catas Altas da Noruega", uf11);
		Municipio mun1186 = new Municipio(null, "Catas Altas", uf11);
		Municipio mun1194 = new Municipio(null, "Catuji", uf11);
		Municipio mun1199 = new Municipio(null, "Catuti", uf11);
		Municipio mun1203 = new Municipio(null, "Caxambu", uf11);
		Municipio mun1211 = new Municipio(null, "Cedro do Abaeté", uf11);
		Municipio mun1218 = new Municipio(null, "Central de Minas", uf11);
		Municipio mun1221 = new Municipio(null, "Centralina", uf11);
		Municipio mun1242 = new Municipio(null, "Chácara", uf11);
		Municipio mun1243 = new Municipio(null, "Chalé", uf11);
		Municipio mun1246 = new Municipio(null, "Chapada do Norte", uf11);
		Municipio mun1248 = new Municipio(null, "Chapada Gaúcha", uf11);
		Municipio mun1261 = new Municipio(null, "Chiador", uf11);
		Municipio mun1277 = new Municipio(null, "Cipotânea", uf11);
		Municipio mun1279 = new Municipio(null, "Claraval", uf11);
		Municipio mun1280 = new Municipio(null, "Claro dos Poções", uf11);
		Municipio mun1282 = new Municipio(null, "Cláudio", uf11);
		Municipio mun1297 = new Municipio(null, "Coimbra", uf11);
		Municipio mun1318 = new Municipio(null, "Coluna", uf11);
		Municipio mun1320 = new Municipio(null, "Comendador Gomes", uf11);
		Municipio mun1322 = new Municipio(null, "Comercinho", uf11);
		Municipio mun1324 = new Municipio(null, "Conceição da Aparecida", uf11);
		Municipio mun1325 = new Municipio(null, "Conceição da Barra de Minas", uf11);
		Municipio mun1328 = new Municipio(null, "Conceição das Alagoas", uf11);
		Municipio mun1329 = new Municipio(null, "Conceição das Pedras", uf11);
		Municipio mun1330 = new Municipio(null, "Conceição de Ipanema", uf11);
		Municipio mun1339 = new Municipio(null, "Conceição do Mato Dentro", uf11);
		Municipio mun1340 = new Municipio(null, "Conceição do Pará", uf11);
		Municipio mun1341 = new Municipio(null, "Conceição do Rio Verde", uf11);
		Municipio mun1343 = new Municipio(null, "Conceição dos Ouros", uf11);
		Municipio mun1355 = new Municipio(null, "Cônego Marinho", uf11);
		Municipio mun1356 = new Municipio(null, "Confins", uf11);
		Municipio mun1359 = new Municipio(null, "Congonhal", uf11);
		Municipio mun1360 = new Municipio(null, "Congonhas do Norte", uf11);
		Municipio mun1361 = new Municipio(null, "Congonhas", uf11);
		Municipio mun1364 = new Municipio(null, "Conquista", uf11);
		Municipio mun1365 = new Municipio(null, "Conselheiro Lafaiete", uf11);
		Municipio mun1367 = new Municipio(null, "Conselheiro Pena", uf11);
		Municipio mun1368 = new Municipio(null, "Consolação", uf11);
		Municipio mun1370 = new Municipio(null, "Contagem", uf11);
		Municipio mun1373 = new Municipio(null, "Coqueiral", uf11);
		Municipio mun1377 = new Municipio(null, "Coração de Jesus", uf11);
		Municipio mun1384 = new Municipio(null, "Cordisburgo", uf11);
		Municipio mun1385 = new Municipio(null, "Cordislândia", uf11);
		Municipio mun1390 = new Municipio(null, "Corinto", uf11);
		Municipio mun1392 = new Municipio(null, "Coroaci", uf11);
		Municipio mun1395 = new Municipio(null, "Coromandel", uf11);
		Municipio mun1400 = new Municipio(null, "Coronel Fabriciano", uf11);
		Municipio mun1407 = new Municipio(null, "Coronel Murta", uf11);
		Municipio mun1408 = new Municipio(null, "Coronel Pacheco", uf11);
		Municipio mun1412 = new Municipio(null, "Coronel Xavier Chaves", uf11);
		Municipio mun1413 = new Municipio(null, "Córrego Danta", uf11);
		Municipio mun1414 = new Municipio(null, "Córrego do Bom Jesus", uf11);
		Municipio mun1416 = new Municipio(null, "Córrego Fundo", uf11);
		Municipio mun1417 = new Municipio(null, "Córrego Novo", uf11);
		Municipio mun1439 = new Municipio(null, "Couto de Magalhães de Minas", uf11);
		Municipio mun1450 = new Municipio(null, "Crisólita", uf11);
		Municipio mun1454 = new Municipio(null, "Cristais", uf11);
		Municipio mun1459 = new Municipio(null, "Cristália", uf11);
		Municipio mun1461 = new Municipio(null, "Cristiano Otoni", uf11);
		Municipio mun1463 = new Municipio(null, "Cristina", uf11);
		Municipio mun1471 = new Municipio(null, "Crucilândia", uf11);
		Municipio mun1479 = new Municipio(null, "Cruzeiro da Fortaleza", uf11);
		Municipio mun1487 = new Municipio(null, "Cruzília", uf11);
		Municipio mun1503 = new Municipio(null, "Cuparaque", uf11);
		Municipio mun1514 = new Municipio(null, "Curral de Dentro", uf11);
		Municipio mun1524 = new Municipio(null, "Curvelo", uf11);
		Municipio mun1532 = new Municipio(null, "Datas", uf11);
		Municipio mun1536 = new Municipio(null, "Delfim Moreira", uf11);
		Municipio mun1537 = new Municipio(null, "Delfinópolis", uf11);
		Municipio mun1539 = new Municipio(null, "Delta", uf11);
		Municipio mun1547 = new Municipio(null, "Descoberto", uf11);
		Municipio mun1548 = new Municipio(null, "Desterro de Entre Rios", uf11);
		Municipio mun1549 = new Municipio(null, "Desterro do Melo", uf11);
		Municipio mun1557 = new Municipio(null, "Diamantina", uf11);
		Municipio mun1562 = new Municipio(null, "Diogo de Vasconcelos", uf11);
		Municipio mun1564 = new Municipio(null, "Dionísio", uf11);
		Municipio mun1569 = new Municipio(null, "Divinésia", uf11);
		Municipio mun1570 = new Municipio(null, "Divino das Laranjeiras", uf11);
		Municipio mun1572 = new Municipio(null, "Divino", uf11);
		Municipio mun1573 = new Municipio(null, "Divinolândia de Minas", uf11);
		Municipio mun1577 = new Municipio(null, "Divinópolis", uf11);
		Municipio mun1578 = new Municipio(null, "Divisa Alegre", uf11);
		Municipio mun1579 = new Municipio(null, "Divisa Nova", uf11);
		Municipio mun1580 = new Municipio(null, "Divisópolis", uf11);
		Municipio mun1593 = new Municipio(null, "Dom Bosco", uf11);
		Municipio mun1594 = new Municipio(null, "Dom Cavati", uf11);
		Municipio mun1599 = new Municipio(null, "Dom Joaquim", uf11);
		Municipio mun1604 = new Municipio(null, "Dom Silvério", uf11);
		Municipio mun1605 = new Municipio(null, "Dom Viçoso", uf11);
		Municipio mun1609 = new Municipio(null, "Dona Eusébia", uf11);
		Municipio mun1612 = new Municipio(null, "Dores de Campos", uf11);
		Municipio mun1613 = new Municipio(null, "Dores de Guanhães", uf11);
		Municipio mun1614 = new Municipio(null, "Dores do Indaiá", uf11);
		Municipio mun1616 = new Municipio(null, "Dores do Turvo", uf11);
		Municipio mun1617 = new Municipio(null, "Doresópolis", uf11);
		Municipio mun1622 = new Municipio(null, "Douradoquara", uf11);
		Municipio mun1639 = new Municipio(null, "Durandé", uf11);
		Municipio mun1654 = new Municipio(null, "Elói Mendes", uf11);
		Municipio mun1666 = new Municipio(null, "Engenheiro Caldas", uf11);
		Municipio mun1668 = new Municipio(null, "Engenheiro Navarro", uf11);
		Municipio mun1671 = new Municipio(null, "Entre Folhas", uf11);
		Municipio mun1672 = new Municipio(null, "Entre Rios de Minas", uf11);
		Municipio mun1690 = new Municipio(null, "Ervália", uf11);
		Municipio mun1693 = new Municipio(null, "Esmeraldas", uf11);
		Municipio mun1694 = new Municipio(null, "Espera Feliz", uf11);
		Municipio mun1703 = new Municipio(null, "Espinosa", uf11);
		Municipio mun1704 = new Municipio(null, "Espírito Santo do Dourado", uf11);
		Municipio mun1715 = new Municipio(null, "Estiva", uf11);
		Municipio mun1718 = new Municipio(null, "Estrela Dalva", uf11);
		Municipio mun1720 = new Municipio(null, "Estrela do Indaiá", uf11);
		Municipio mun1723 = new Municipio(null, "Estrela do Sul", uf11);
		Municipio mun1729 = new Municipio(null, "Eugenópolis", uf11);
		Municipio mun1732 = new Municipio(null, "Ewbank da Câmara", uf11);
		Municipio mun1733 = new Municipio(null, "Extrema", uf11);
		Municipio mun1739 = new Municipio(null, "Fama", uf11);
		Municipio mun1740 = new Municipio(null, "Faria Lemos", uf11);
		Municipio mun1764 = new Municipio(null, "Felício dos Santos", uf11);
		Municipio mun1766 = new Municipio(null, "Felisburgo", uf11);
		Municipio mun1767 = new Municipio(null, "Felixlândia", uf11);
		Municipio mun1773 = new Municipio(null, "Fernandes Tourinho", uf11);
		Municipio mun1783 = new Municipio(null, "Ferros", uf11);
		Municipio mun1784 = new Municipio(null, "Fervedouro", uf11);
		Municipio mun1809 = new Municipio(null, "Florestal", uf11);
		Municipio mun1819 = new Municipio(null, "Formiga", uf11);
		Municipio mun1827 = new Municipio(null, "Formoso", uf11);
		Municipio mun1832 = new Municipio(null, "Fortaleza de Minas", uf11);
		Municipio mun1838 = new Municipio(null, "Fortuna de Minas", uf11);
		Municipio mun1847 = new Municipio(null, "Francisco Badaró", uf11);
		Municipio mun1850 = new Municipio(null, "Francisco Dumont", uf11);
		Municipio mun1853 = new Municipio(null, "Francisco Sá", uf11);
		Municipio mun1855 = new Municipio(null, "Franciscópolis", uf11);
		Municipio mun1859 = new Municipio(null, "Frei Gaspar", uf11);
		Municipio mun1860 = new Municipio(null, "Frei Inocêncio", uf11);
		Municipio mun1861 = new Municipio(null, "Frei Lagonegro", uf11);
		Municipio mun1866 = new Municipio(null, "Fronteira dos Vales", uf11);
		Municipio mun1867 = new Municipio(null, "Fronteira", uf11);
		Municipio mun1869 = new Municipio(null, "Fruta de Leite", uf11);
		Municipio mun1870 = new Municipio(null, "Frutal", uf11);
		Municipio mun1873 = new Municipio(null, "Funilândia", uf11);
		Municipio mun1877 = new Municipio(null, "Galiléia", uf11);
		Municipio mun1882 = new Municipio(null, "Gameleiras", uf11);
		Municipio mun1912 = new Municipio(null, "Glaucilândia", uf11);
		Municipio mun1921 = new Municipio(null, "Goiabeira", uf11);
		Municipio mun1922 = new Municipio(null, "Goianá", uf11);
		Municipio mun1938 = new Municipio(null, "Gonçalves", uf11);
		Municipio mun1940 = new Municipio(null, "Gonzaga", uf11);
		Municipio mun1941 = new Municipio(null, "Gouveia", uf11);
		Municipio mun1954 = new Municipio(null, "Governador Valadares", uf11);
		Municipio mun1966 = new Municipio(null, "Grão Mogol", uf11);
		Municipio mun1973 = new Municipio(null, "Grupiara", uf11);
		Municipio mun1991 = new Municipio(null, "Guanhães", uf11);
		Municipio mun1992 = new Municipio(null, "Guapé", uf11);
		Municipio mun2006 = new Municipio(null, "Guaraciaba", uf11);
		Municipio mun2008 = new Municipio(null, "Guaraciama", uf11);
		Municipio mun2013 = new Municipio(null, "Guaranésia", uf11);
		Municipio mun2017 = new Municipio(null, "Guarani", uf11);
		Municipio mun2024 = new Municipio(null, "Guarará", uf11);
		Municipio mun2030 = new Municipio(null, "Guarda-Mor", uf11);
		Municipio mun2040 = new Municipio(null, "Guaxupé", uf11);
		Municipio mun2042 = new Municipio(null, "Guidoval", uf11);
		Municipio mun2044 = new Municipio(null, "Guimarânia", uf11);
		Municipio mun2046 = new Municipio(null, "Guiricema", uf11);
		Municipio mun2047 = new Municipio(null, "Gurinhatã", uf11);
		Municipio mun2055 = new Municipio(null, "Heliodora", uf11);
		Municipio mun2078 = new Municipio(null, "Iapu", uf11);
		Municipio mun2088 = new Municipio(null, "Ibertioga", uf11);
		Municipio mun2089 = new Municipio(null, "Ibiá", uf11);
		Municipio mun2091 = new Municipio(null, "Ibiaí", uf11);
		Municipio mun2107 = new Municipio(null, "Ibiracatu", uf11);
		Municipio mun2108 = new Municipio(null, "Ibiraci", uf11);
		Municipio mun2118 = new Municipio(null, "Ibirité", uf11);
		Municipio mun2124 = new Municipio(null, "Ibitiúra de Minas", uf11);
		Municipio mun2125 = new Municipio(null, "Ibituruna", uf11);
		Municipio mun2130 = new Municipio(null, "Icaraí de Minas", uf11);
		Municipio mun2146 = new Municipio(null, "Igarapé", uf11);
		Municipio mun2151 = new Municipio(null, "Igaratinga", uf11);
		Municipio mun2160 = new Municipio(null, "Iguatama", uf11);
		Municipio mun2164 = new Municipio(null, "Ijaci", uf11);
		Municipio mun2174 = new Municipio(null, "Ilicínea", uf11);
		Municipio mun2179 = new Municipio(null, "Imbé de Minas", uf11);
		Municipio mun2190 = new Municipio(null, "Inconfidentes", uf11);
		Municipio mun2191 = new Municipio(null, "Indaiabira", uf11);
		Municipio mun2197 = new Municipio(null, "Indianópolis", uf11);
		Municipio mun2204 = new Municipio(null, "Ingaí", uf11);
		Municipio mun2210 = new Municipio(null, "Inhapim", uf11);
		Municipio mun2211 = new Municipio(null, "Inhaúma", uf11);
		Municipio mun2214 = new Municipio(null, "Inimutaba", uf11);
		Municipio mun2218 = new Municipio(null, "Ipaba", uf11);
		Municipio mun2220 = new Municipio(null, "Ipanema", uf11);
		Municipio mun2223 = new Municipio(null, "Ipatinga", uf11);
		Municipio mun2230 = new Municipio(null, "Ipiaçu", uf11);
		Municipio mun2254 = new Municipio(null, "Ipuiúna", uf11);
		Municipio mun2262 = new Municipio(null, "Iraí de Minas", uf11);
		Municipio mun2292 = new Municipio(null, "Itabira", uf11);
		Municipio mun2293 = new Municipio(null, "Itabirinha de Mantena", uf11);
		Municipio mun2294 = new Municipio(null, "Itabirito", uf11);
		Municipio mun2298 = new Municipio(null, "Itacambira", uf11);
		Municipio mun2299 = new Municipio(null, "Itacarambi", uf11);
		Municipio mun2312 = new Municipio(null, "Itaguara", uf11);
		Municipio mun2322 = new Municipio(null, "Itaipé", uf11);
		Municipio mun2332 = new Municipio(null, "Itajubá", uf11);
		Municipio mun2336 = new Municipio(null, "Itamarandiba", uf11);
		Municipio mun2337 = new Municipio(null, "Itamarati de Minas", uf11);
		Municipio mun2340 = new Municipio(null, "Itambacuri", uf11);
		Municipio mun2342 = new Municipio(null, "Itambé do Mato Dentro", uf11);
		Municipio mun2346 = new Municipio(null, "Itamogi", uf11);
		Municipio mun2347 = new Municipio(null, "Itamonte", uf11);
		Municipio mun2350 = new Municipio(null, "Itanhandu", uf11);
		Municipio mun2353 = new Municipio(null, "Itanhomi", uf11);
		Municipio mun2354 = new Municipio(null, "Itaobim", uf11);
		Municipio mun2359 = new Municipio(null, "Itapagipe", uf11);
		Municipio mun2364 = new Municipio(null, "Itapecerica", uf11);
		Municipio mun2374 = new Municipio(null, "Itapeva", uf11);
		Municipio mun2414 = new Municipio(null, "Itatiaiuçu", uf11);
		Municipio mun2421 = new Municipio(null, "Itaú de Minas", uf11);
		Municipio mun2428 = new Municipio(null, "Itaúna", uf11);
		Municipio mun2429 = new Municipio(null, "Itaverava", uf11);
		Municipio mun2431 = new Municipio(null, "Itinga", uf11);
		Municipio mun2442 = new Municipio(null, "Itueta", uf11);
		Municipio mun2443 = new Municipio(null, "Ituiutaba", uf11);
		Municipio mun2445 = new Municipio(null, "Itumirim", uf11);
		Municipio mun2449 = new Municipio(null, "Iturama", uf11);
		Municipio mun2450 = new Municipio(null, "Itutinga", uf11);
		Municipio mun2469 = new Municipio(null, "Jaboticatubas", uf11);
		Municipio mun2480 = new Municipio(null, "Jacinto", uf11);
		Municipio mun2483 = new Municipio(null, "Jacuí", uf11);
		Municipio mun2488 = new Municipio(null, "Jacutinga", uf11);
		Municipio mun2492 = new Municipio(null, "Jaguaraçu", uf11);
		Municipio mun2505 = new Municipio(null, "Jaíba", uf11);
		Municipio mun2509 = new Municipio(null, "Jampruca", uf11);
		Municipio mun2510 = new Municipio(null, "Janaúba", uf11);
		Municipio mun2519 = new Municipio(null, "Januária", uf11);
		Municipio mun2521 = new Municipio(null, "Japaraíba", uf11);
		Municipio mun2528 = new Municipio(null, "Japonvar", uf11);
		Municipio mun2563 = new Municipio(null, "Jeceaba", uf11);
		Municipio mun2564 = new Municipio(null, "Jenipapo de Minas", uf11);
		Municipio mun2566 = new Municipio(null, "Jequeri", uf11);
		Municipio mun2569 = new Municipio(null, "Jequitaí", uf11);
		Municipio mun2570 = new Municipio(null, "Jequitibá", uf11);
		Municipio mun2571 = new Municipio(null, "Jequitinhonha", uf11);
		Municipio mun2577 = new Municipio(null, "Jesuânia", uf11);
		Municipio mun2585 = new Municipio(null, "Joaíma", uf11);
		Municipio mun2586 = new Municipio(null, "Joanésia", uf11);
		Municipio mun2594 = new Municipio(null, "João Monlevade", uf11);
		Municipio mun2597 = new Municipio(null, "João Pinheiro", uf11);
		Municipio mun2599 = new Municipio(null, "Joaquim Felício", uf11);
		Municipio mun2607 = new Municipio(null, "Jordânia", uf11);
		Municipio mun2613 = new Municipio(null, "José Gonçalves de Minas", uf11);
		Municipio mun2614 = new Municipio(null, "José Raydan", uf11);
		Municipio mun2616 = new Municipio(null, "Josenópolis", uf11);
		Municipio mun2621 = new Municipio(null, "Juatuba", uf11);
		Municipio mun2631 = new Municipio(null, "Juiz de Fora", uf11);
		Municipio mun2648 = new Municipio(null, "Juramento", uf11);
		Municipio mun2655 = new Municipio(null, "Juruaia", uf11);
		Municipio mun2666 = new Municipio(null, "Juvenília", uf11);
		Municipio mun2670 = new Municipio(null, "Ladainha", uf11);
		Municipio mun2673 = new Municipio(null, "Lagamar", uf11);
		Municipio mun2685 = new Municipio(null, "Lagoa da Prata", uf11);
		Municipio mun2699 = new Municipio(null, "Lagoa dos Patos", uf11);
		Municipio mun2701 = new Municipio(null, "Lagoa Dourada", uf11);
		Municipio mun2702 = new Municipio(null, "Lagoa Formosa", uf11);
		Municipio mun2704 = new Municipio(null, "Lagoa Grande", uf11);
		Municipio mun2709 = new Municipio(null, "Lagoa Santa", uf11);
		Municipio mun2732 = new Municipio(null, "Lajinha", uf11);
		Municipio mun2735 = new Municipio(null, "Lambari", uf11);
		Municipio mun2736 = new Municipio(null, "Lamim", uf11);
		Municipio mun2743 = new Municipio(null, "Laranjal", uf11);
		Municipio mun2747 = new Municipio(null, "Lassance", uf11);
		Municipio mun2756 = new Municipio(null, "Lavras", uf11);
		Municipio mun2758 = new Municipio(null, "Leandro Ferreira", uf11);
		Municipio mun2760 = new Municipio(null, "Leme do Prado", uf11);
		Municipio mun2765 = new Municipio(null, "Leopoldina", uf11);
		Municipio mun2769 = new Municipio(null, "Liberdade", uf11);
		Municipio mun2773 = new Municipio(null, "Lima Duarte", uf11);
		Municipio mun2774 = new Municipio(null, "Limeira do Oeste", uf11);
		Municipio mun2794 = new Municipio(null, "Lontra", uf11);
		Municipio mun2811 = new Municipio(null, "Luisburgo", uf11);
		Municipio mun2812 = new Municipio(null, "Luislândia", uf11);
		Municipio mun2816 = new Municipio(null, "Luminárias", uf11);
		Municipio mun2821 = new Municipio(null, "Luz", uf11);
		Municipio mun2840 = new Municipio(null, "Machacalis", uf11);
		Municipio mun2843 = new Municipio(null, "Machado", uf11);
		Municipio mun2850 = new Municipio(null, "Madre de Deus de Minas", uf11);
		Municipio mun2869 = new Municipio(null, "Malacacheta", uf11);
		Municipio mun2879 = new Municipio(null, "Mamonas", uf11);
		Municipio mun2892 = new Municipio(null, "Manga", uf11);
		Municipio mun2895 = new Municipio(null, "Manhuaçu", uf11);
		Municipio mun2896 = new Municipio(null, "Manhumirim", uf11);
		Municipio mun2904 = new Municipio(null, "Mantena", uf11);
		Municipio mun2907 = new Municipio(null, "Mar de Espanha", uf11);
		Municipio mun2934 = new Municipio(null, "Maravilhas", uf11);
		Municipio mun2949 = new Municipio(null, "Maria da Fé", uf11);
		Municipio mun2953 = new Municipio(null, "Mariana", uf11);
		Municipio mun2959 = new Municipio(null, "Marilac", uf11);
		Municipio mun2967 = new Municipio(null, "Mário Campos", uf11);
		Municipio mun2969 = new Municipio(null, "Maripá de Minas", uf11);
		Municipio mun2973 = new Municipio(null, "Marliéria", uf11);
		Municipio mun2975 = new Municipio(null, "Marmelópolis", uf11);
		Municipio mun2978 = new Municipio(null, "Martinho Campos", uf11);
		Municipio mun2981 = new Municipio(null, "Martins Soares", uf11);
		Municipio mun2994 = new Municipio(null, "Mata Verde", uf11);
		Municipio mun3000 = new Municipio(null, "Materlândia", uf11);
		Municipio mun3001 = new Municipio(null, "Mateus Leme", uf11);
		Municipio mun3002 = new Municipio(null, "Mathias Lobato", uf11);
		Municipio mun3003 = new Municipio(null, "Matias Barbosa", uf11);
		Municipio mun3004 = new Municipio(null, "Matias Cardoso", uf11);
		Municipio mun3010 = new Municipio(null, "Matipó", uf11);
		Municipio mun3016 = new Municipio(null, "Mato Verde", uf11);
		Municipio mun3020 = new Municipio(null, "Matozinhos", uf11);
		Municipio mun3025 = new Municipio(null, "Matutina", uf11);
		Municipio mun3036 = new Municipio(null, "Medeiros", uf11);
		Municipio mun3039 = new Municipio(null, "Medina", uf11);
		Municipio mun3042 = new Municipio(null, "Mendes Pimentel", uf11);
		Municipio mun3046 = new Municipio(null, "Mercês", uf11);
		Municipio mun3050 = new Municipio(null, "Mesquita", uf11);
		Municipio mun3069 = new Municipio(null, "Minas Novas", uf11);
		Municipio mun3070 = new Municipio(null, "Minduri", uf11);
		Municipio mun3075 = new Municipio(null, "Mirabela", uf11);
		Municipio mun3081 = new Municipio(null, "Miradouro", uf11);
		Municipio mun3083 = new Municipio(null, "Miraí", uf11);
		Municipio mun3098 = new Municipio(null, "Miravânia", uf11);
		Municipio mun3106 = new Municipio(null, "Moeda", uf11);
		Municipio mun3107 = new Municipio(null, "Moema", uf11);
		Municipio mun3121 = new Municipio(null, "Monjolos", uf11);
		Municipio mun3124 = new Municipio(null, "Monsenhor Paulo", uf11);
		Municipio mun3127 = new Municipio(null, "Montalvânia", uf11);
		Municipio mun3132 = new Municipio(null, "Monte Alegre de Minas", uf11);
		Municipio mun3142 = new Municipio(null, "Monte Azul", uf11);
		Municipio mun3144 = new Municipio(null, "Monte Belo", uf11);
		Municipio mun3146 = new Municipio(null, "Monte Carmelo", uf11);
		Municipio mun3151 = new Municipio(null, "Monte Formoso", uf11);
		Municipio mun3155 = new Municipio(null, "Monte Santo de Minas", uf11);
		Municipio mun3158 = new Municipio(null, "Monte Sião", uf11);
		Municipio mun3165 = new Municipio(null, "Montes Claros", uf11);
		Municipio mun3166 = new Municipio(null, "Montezuma", uf11);
		Municipio mun3169 = new Municipio(null, "Morada Nova de Minas", uf11);
		Municipio mun3185 = new Municipio(null, "Morro da Garça", uf11);
		Municipio mun3188 = new Municipio(null, "Morro do Pilar", uf11);
		Municipio mun3216 = new Municipio(null, "Munhoz", uf11);
		Municipio mun3221 = new Municipio(null, "Muriaé", uf11);
		Municipio mun3229 = new Municipio(null, "Mutum", uf11);
		Municipio mun3231 = new Municipio(null, "Muzambinho", uf11);
		Municipio mun3232 = new Municipio(null, "Nacip Raydan", uf11);
		Municipio mun3234 = new Municipio(null, "Nanuque", uf11);
		Municipio mun3236 = new Municipio(null, "Naque", uf11);
		Municipio mun3239 = new Municipio(null, "Natalândia", uf11);
		Municipio mun3240 = new Municipio(null, "Natércia", uf11);
		Municipio mun3252 = new Municipio(null, "Nazareno", uf11);
		Municipio mun3256 = new Municipio(null, "Nepomuceno", uf11);
		Municipio mun3265 = new Municipio(null, "Ninheira", uf11);
		Municipio mun3297 = new Municipio(null, "Nova Belém", uf11);
		Municipio mun3312 = new Municipio(null, "Nova Era", uf11);
		Municipio mun3338 = new Municipio(null, "Nova Lima", uf11);
		Municipio mun3344 = new Municipio(null, "Nova Módica", uf11);
		Municipio mun3359 = new Municipio(null, "Nova Ponte", uf11);
		Municipio mun3360 = new Municipio(null, "Nova Porteirinha", uf11);
		Municipio mun3365 = new Municipio(null, "Nova Resende", uf11);
		Municipio mun3375 = new Municipio(null, "Nova Serrana", uf11);
		Municipio mun3381 = new Municipio(null, "Nova União", uf11);
		Municipio mun3396 = new Municipio(null, "Novo Cruzeiro", uf11);
		Municipio mun3410 = new Municipio(null, "Novo Oriente de Minas", uf11);
		Municipio mun3422 = new Municipio(null, "Novorizonte", uf11);
		Municipio mun3430 = new Municipio(null, "Olaria", uf11);
		Municipio mun3439 = new Municipio(null, "Olhos-d'Água", uf11);
		Municipio mun3441 = new Municipio(null, "Olímpio Noronha", uf11);
		Municipio mun3448 = new Municipio(null, "Oliveira Fortes", uf11);
		Municipio mun3449 = new Municipio(null, "Oliveira", uf11);
		Municipio mun3451 = new Municipio(null, "Onça de Pitangui", uf11);
		Municipio mun3453 = new Municipio(null, "Oratórios", uf11);
		Municipio mun3457 = new Municipio(null, "Orizânia", uf11);
		Municipio mun3476 = new Municipio(null, "Ouro Branco", uf11);
		Municipio mun3479 = new Municipio(null, "Ouro Fino", uf11);
		Municipio mun3481 = new Municipio(null, "Ouro Preto", uf11);
		Municipio mun3484 = new Municipio(null, "Ouro Verde de Minas", uf11);
		Municipio mun3502 = new Municipio(null, "Padre Carvalho", uf11);
		Municipio mun3504 = new Municipio(null, "Padre Paraíso", uf11);
		Municipio mun3506 = new Municipio(null, "Pai Pedro", uf11);
		Municipio mun3510 = new Municipio(null, "Paineiras", uf11);
		Municipio mun3512 = new Municipio(null, "Pains", uf11);
		Municipio mun3513 = new Municipio(null, "Paiva", uf11);
		Municipio mun3522 = new Municipio(null, "Palma", uf11);
		Municipio mun3550 = new Municipio(null, "Palmópolis", uf11);
		Municipio mun3559 = new Municipio(null, "Papagaios", uf11);
		Municipio mun3562 = new Municipio(null, "Pará de Minas", uf11);
		Municipio mun3564 = new Municipio(null, "Paracatu", uf11);
		Municipio mun3568 = new Municipio(null, "Paraguaçu", uf11);
		Municipio mun3579 = new Municipio(null, "Paraisópolis", uf11);
		Municipio mun3597 = new Municipio(null, "Paraopeba", uf11);
		Municipio mun3623 = new Municipio(null, "Passa Quatro", uf11);
		Municipio mun3625 = new Municipio(null, "Passa Tempo", uf11);
		Municipio mun3626 = new Municipio(null, "Passabém", uf11);
		Municipio mun3631 = new Municipio(null, "Passa-Vinte", uf11);
		Municipio mun3638 = new Municipio(null, "Passos", uf11);
		Municipio mun3640 = new Municipio(null, "Patis", uf11);
		Municipio mun3643 = new Municipio(null, "Patos de Minas", uf11);
		Municipio mun3646 = new Municipio(null, "Patrocínio do Muriaé", uf11);
		Municipio mun3648 = new Municipio(null, "Patrocínio", uf11);
		Municipio mun3658 = new Municipio(null, "Paula Cândido", uf11);
		Municipio mun3667 = new Municipio(null, "Paulistas", uf11);
		Municipio mun3675 = new Municipio(null, "Pavão", uf11);
		Municipio mun3680 = new Municipio(null, "Peçanha", uf11);
		Municipio mun3682 = new Municipio(null, "Pedra Azul", uf11);
		Municipio mun3684 = new Municipio(null, "Pedra Bonita", uf11);
		Municipio mun3688 = new Municipio(null, "Pedra do Anta", uf11);
		Municipio mun3689 = new Municipio(null, "Pedra do Indaiá", uf11);
		Municipio mun3690 = new Municipio(null, "Pedra Dourada", uf11);
		Municipio mun3697 = new Municipio(null, "Pedralva", uf11);
		Municipio mun3702 = new Municipio(null, "Pedras de Maria da Cruz", uf11);
		Municipio mun3709 = new Municipio(null, "Pedrinópolis", uf11);
		Municipio mun3719 = new Municipio(null, "Pedro Leopoldo", uf11);
		Municipio mun3722 = new Municipio(null, "Pedro Teixeira", uf11);
		Municipio mun3736 = new Municipio(null, "Pequeri", uf11);
		Municipio mun3737 = new Municipio(null, "Pequi", uf11);
		Municipio mun3739 = new Municipio(null, "Perdigão", uf11);
		Municipio mun3740 = new Municipio(null, "Perdizes", uf11);
		Municipio mun3741 = new Municipio(null, "Perdões", uf11);
		Municipio mun3746 = new Municipio(null, "Periquito", uf11);
		Municipio mun3754 = new Municipio(null, "Pescador", uf11);
		Municipio mun3765 = new Municipio(null, "Piau", uf11);
		Municipio mun3771 = new Municipio(null, "Piedade de Caratinga", uf11);
		Municipio mun3772 = new Municipio(null, "Piedade de Ponte Nova", uf11);
		Municipio mun3773 = new Municipio(null, "Piedade do Rio Grande", uf11);
		Municipio mun3774 = new Municipio(null, "Piedade dos Gerais", uf11);
		Municipio mun3786 = new Municipio(null, "Pimenta", uf11);
		Municipio mun3797 = new Municipio(null, "Pingo-d'Água", uf11);
		Municipio mun3815 = new Municipio(null, "Pintópolis", uf11);
		Municipio mun3823 = new Municipio(null, "Piracema", uf11);
		Municipio mun3830 = new Municipio(null, "Pirajuba", uf11);
		Municipio mun3833 = new Municipio(null, "Piranga", uf11);
		Municipio mun3835 = new Municipio(null, "Piranguçu", uf11);
		Municipio mun3836 = new Municipio(null, "Piranguinho", uf11);
		Municipio mun3840 = new Municipio(null, "Pirapetinga", uf11);
		Municipio mun3843 = new Municipio(null, "Pirapora", uf11);
		Municipio mun3851 = new Municipio(null, "Piraúba", uf11);
		Municipio mun3862 = new Municipio(null, "Pitangui", uf11);
		Municipio mun3866 = new Municipio(null, "Piumhi", uf11);
		Municipio mun3878 = new Municipio(null, "Planura", uf11);
		Municipio mun3889 = new Municipio(null, "Poço Fundo", uf11);
		Municipio mun3894 = new Municipio(null, "Poços de Caldas", uf11);
		Municipio mun3895 = new Municipio(null, "Pocrane", uf11);
		Municipio mun3902 = new Municipio(null, "Pompéu", uf11);
		Municipio mun3918 = new Municipio(null, "Ponte Nova", uf11);
		Municipio mun3924 = new Municipio(null, "Ponto Chique", uf11);
		Municipio mun3925 = new Municipio(null, "Ponto dos Volantes", uf11);
		Municipio mun3937 = new Municipio(null, "Porteirinha", uf11);
		Municipio mun3958 = new Municipio(null, "Porto Firme", uf11);
		Municipio mun3978 = new Municipio(null, "Poté", uf11);
		Municipio mun3984 = new Municipio(null, "Pouso Alegre", uf11);
		Municipio mun3985 = new Municipio(null, "Pouso Alto", uf11);
		Municipio mun3994 = new Municipio(null, "Prados", uf11);
		Municipio mun4001 = new Municipio(null, "Prata", uf11);
		Municipio mun4004 = new Municipio(null, "Pratápolis", uf11);
		Municipio mun4005 = new Municipio(null, "Pratinha", uf11);
		Municipio mun4007 = new Municipio(null, "Presidente Bernardes", uf11);
		Municipio mun4018 = new Municipio(null, "Presidente Juscelino", uf11);
		Municipio mun4022 = new Municipio(null, "Presidente Kubitschek", uf11);
		Municipio mun4027 = new Municipio(null, "Presidente Olegário", uf11);
		Municipio mun4046 = new Municipio(null, "Prudente de Morais", uf11);
		Municipio mun4054 = new Municipio(null, "Quartel Geral", uf11);
		Municipio mun4071 = new Municipio(null, "Queluzito", uf11);
		Municipio mun4102 = new Municipio(null, "Raposos", uf11);
		Municipio mun4103 = new Municipio(null, "Raul Soares", uf11);
		Municipio mun4107 = new Municipio(null, "Recreio", uf11);
		Municipio mun4114 = new Municipio(null, "Reduto", uf11);
		Municipio mun4124 = new Municipio(null, "Resende Costa", uf11);
		Municipio mun4129 = new Municipio(null, "Resplendor", uf11);
		Municipio mun4130 = new Municipio(null, "Ressaquinha", uf11);
		Municipio mun4141 = new Municipio(null, "Riachinho", uf11);
		Municipio mun4149 = new Municipio(null, "Riacho dos Machados", uf11);
		Municipio mun4166 = new Municipio(null, "Ribeirão das Neves", uf11);
		Municipio mun4174 = new Municipio(null, "Ribeirão Vermelho", uf11);
		Municipio mun4182 = new Municipio(null, "Rio Acima", uf11);
		Municipio mun4193 = new Municipio(null, "Rio Casca", uf11);
		Municipio mun4209 = new Municipio(null, "Rio do Prado", uf11);
		Municipio mun4211 = new Municipio(null, "Rio Doce", uf11);
		Municipio mun4215 = new Municipio(null, "Rio Espera", uf11);
		Municipio mun4222 = new Municipio(null, "Rio Manso", uf11);
		Municipio mun4228 = new Municipio(null, "Rio Novo", uf11);
		Municipio mun4229 = new Municipio(null, "Rio Paranaíba", uf11);
		Municipio mun4230 = new Municipio(null, "Rio Pardo de Minas", uf11);
		Municipio mun4232 = new Municipio(null, "Rio Piracicaba", uf11);
		Municipio mun4233 = new Municipio(null, "Rio Pomba", uf11);
		Municipio mun4235 = new Municipio(null, "Rio Preto", uf11);
		Municipio mun4243 = new Municipio(null, "Rio Vermelho", uf11);
		Municipio mun4247 = new Municipio(null, "Ritápolis", uf11);
		Municipio mun4250 = new Municipio(null, "Rochedo de Minas", uf11);
		Municipio mun4254 = new Municipio(null, "Rodeiro", uf11);
		Municipio mun4262 = new Municipio(null, "Romaria", uf11);
		Municipio mun4274 = new Municipio(null, "Rosário da Limeira", uf11);
		Municipio mun4282 = new Municipio(null, "Rubelita", uf11);
		Municipio mun4285 = new Municipio(null, "Rubim", uf11);
		Municipio mun4291 = new Municipio(null, "Sabará", uf11);
		Municipio mun4294 = new Municipio(null, "Sabinópolis", uf11);
		Municipio mun4296 = new Municipio(null, "Sacramento", uf11);
		Municipio mun4312 = new Municipio(null, "Salinas", uf11);
		Municipio mun4319 = new Municipio(null, "Salto da Divisa", uf11);
		Municipio mun4345 = new Municipio(null, "Santa Bárbara do Leste", uf11);
		Municipio mun4346 = new Municipio(null, "Santa Bárbara do Monte Verde", uf11);
		Municipio mun4349 = new Municipio(null, "Santa Bárbara do Tugúrio", uf11);
		Municipio mun4350 = new Municipio(null, "Santa Bárbara", uf11);
		Municipio mun4368 = new Municipio(null, "Santa Cruz de Minas", uf11);
		Municipio mun4370 = new Municipio(null, "Santa Cruz de Salinas", uf11);
		Municipio mun4373 = new Municipio(null, "Santa Cruz do Escalvado", uf11);
		Municipio mun4382 = new Municipio(null, "Santa Efigênia de Minas", uf11);
		Municipio mun4385 = new Municipio(null, "Santa Fé de Minas", uf11);
		Municipio mun4394 = new Municipio(null, "Santa Helena de Minas", uf11);
		Municipio mun4409 = new Municipio(null, "Santa Juliana", uf11);
		Municipio mun4420 = new Municipio(null, "Santa Luzia", uf11);
		Municipio mun4424 = new Municipio(null, "Santa Margarida", uf11);
		Municipio mun4429 = new Municipio(null, "Santa Maria de Itabira", uf11);
		Municipio mun4435 = new Municipio(null, "Santa Maria do Salto", uf11);
		Municipio mun4436 = new Municipio(null, "Santa Maria do Suaçuí", uf11);
		Municipio mun4447 = new Municipio(null, "Santa Rita de Caldas", uf11);
		Municipio mun4449 = new Municipio(null, "Santa Rita de Ibitipoca", uf11);
		Municipio mun4450 = new Municipio(null, "Santa Rita de Jacutinga", uf11);
		Municipio mun4451 = new Municipio(null, "Santa Rita de Minas", uf11);
		Municipio mun4453 = new Municipio(null, "Santa Rita do Itueto", uf11);
		Municipio mun4457 = new Municipio(null, "Santa Rita do Sapucaí", uf11);
		Municipio mun4462 = new Municipio(null, "Santa Rosa da Serra", uf11);
		Municipio mun4488 = new Municipio(null, "Santa Vitória", uf11);
		Municipio mun4492 = new Municipio(null, "Santana da Vargem", uf11);
		Municipio mun4493 = new Municipio(null, "Santana de Cataguases", uf11);
		Municipio mun4496 = new Municipio(null, "Santana de Pirapama", uf11);
		Municipio mun4500 = new Municipio(null, "Santana do Deserto", uf11);
		Municipio mun4501 = new Municipio(null, "Santana do Garambéu", uf11);
		Municipio mun4504 = new Municipio(null, "Santana do Jacaré", uf11);
		Municipio mun4506 = new Municipio(null, "Santana do Manhuaçu", uf11);
		Municipio mun4510 = new Municipio(null, "Santana do Paraíso", uf11);
		Municipio mun4512 = new Municipio(null, "Santana do Riacho", uf11);
		Municipio mun4516 = new Municipio(null, "Santana dos Montes", uf11);
		Municipio mun4544 = new Municipio(null, "Santo Antônio do Amparo", uf11);
		Municipio mun4546 = new Municipio(null, "Santo Antônio do Aventureiro", uf11);
		Municipio mun4549 = new Municipio(null, "Santo Antônio do Grama", uf11);
		Municipio mun4551 = new Municipio(null, "Santo Antônio do Itambé", uf11);
		Municipio mun4552 = new Municipio(null, "Santo Antônio do Jacinto", uf11);
		Municipio mun4556 = new Municipio(null, "Santo Antônio do Monte", uf11);
		Municipio mun4561 = new Municipio(null, "Santo Antônio do Retiro", uf11);
		Municipio mun4562 = new Municipio(null, "Santo Antônio do Rio Abaixo", uf11);
		Municipio mun4573 = new Municipio(null, "Santo Hipólito", uf11);
		Municipio mun4577 = new Municipio(null, "Santos Dumont", uf11);
		Municipio mun4583 = new Municipio(null, "São Bento Abade", uf11);
		Municipio mun4597 = new Municipio(null, "São Brás do Suaçuí", uf11);
		Municipio mun4609 = new Municipio(null, "São Domingos das Dores", uf11);
		Municipio mun4617 = new Municipio(null, "São Domingos do Prata", uf11);
		Municipio mun4626 = new Municipio(null, "São Félix de Minas", uf11);
		Municipio mun4639 = new Municipio(null, "São Francisco de Paula", uf11);
		Municipio mun4641 = new Municipio(null, "São Francisco de Sales", uf11);
		Municipio mun4644 = new Municipio(null, "São Francisco do Glória", uf11);
		Municipio mun4651 = new Municipio(null, "São Francisco", uf11);
		Municipio mun4660 = new Municipio(null, "São Geraldo da Piedade", uf11);
		Municipio mun4662 = new Municipio(null, "São Geraldo do Baixio", uf11);
		Municipio mun4663 = new Municipio(null, "São Geraldo", uf11);
		Municipio mun4664 = new Municipio(null, "São Gonçalo do Abaeté", uf11);
		Municipio mun4668 = new Municipio(null, "São Gonçalo do Pará", uf11);
		Municipio mun4670 = new Municipio(null, "São Gonçalo do Rio Abaixo", uf11);
		Municipio mun4671 = new Municipio(null, "São Gonçalo do Rio Preto", uf11);
		Municipio mun4672 = new Municipio(null, "São Gonçalo do Sapucaí", uf11);
		Municipio mun4675 = new Municipio(null, "São Gotardo", uf11);
		Municipio mun4678 = new Municipio(null, "São João Batista do Glória", uf11);
		Municipio mun4687 = new Municipio(null, "São João da Lagoa", uf11);
		Municipio mun4688 = new Municipio(null, "São João da Mata", uf11);
		Municipio mun4691 = new Municipio(null, "São João da Ponte", uf11);
		Municipio mun4696 = new Municipio(null, "São João das Missões", uf11);
		Municipio mun4700 = new Municipio(null, "São João del Rei", uf11);
		Municipio mun4709 = new Municipio(null, "São João do Manhuaçu", uf11);
		Municipio mun4710 = new Municipio(null, "São João do Manteninha", uf11);
		Municipio mun4712 = new Municipio(null, "São João do Oriente", uf11);
		Municipio mun4713 = new Municipio(null, "São João do Pacuí", uf11);
		Municipio mun4715 = new Municipio(null, "São João do Paraíso", uf11);
		Municipio mun4726 = new Municipio(null, "São João Evangelista", uf11);
		Municipio mun4727 = new Municipio(null, "São João Nepomuceno", uf11);
		Municipio mun4731 = new Municipio(null, "São Joaquim de Bicas", uf11);
		Municipio mun4738 = new Municipio(null, "São José da Barra", uf11);
		Municipio mun4744 = new Municipio(null, "São José da Lapa", uf11);
		Municipio mun4745 = new Municipio(null, "São José da Safira", uf11);
		Municipio mun4747 = new Municipio(null, "São José da Varginha", uf11);
		Municipio mun4758 = new Municipio(null, "São José do Alegre", uf11);
		Municipio mun4767 = new Municipio(null, "São José do Divino", uf11);
		Municipio mun4770 = new Municipio(null, "São José do Goiabal", uf11);
		Municipio mun4775 = new Municipio(null, "São José do Jacuri", uf11);
		Municipio mun4776 = new Municipio(null, "São José do Mantimento", uf11);
		Municipio mun4805 = new Municipio(null, "São Lourenço", uf11);
		Municipio mun4834 = new Municipio(null, "São Miguel do Anta", uf11);
		Municipio mun4858 = new Municipio(null, "São Pedro da União", uf11);
		Municipio mun4866 = new Municipio(null, "São Pedro do Suaçuí", uf11);
		Municipio mun4870 = new Municipio(null, "São Pedro dos Ferros", uf11);
		Municipio mun4878 = new Municipio(null, "São Romão", uf11);
		Municipio mun4879 = new Municipio(null, "São Roque de Minas", uf11);
		Municipio mun4884 = new Municipio(null, "São Sebastião da Bela Vista", uf11);
		Municipio mun4887 = new Municipio(null, "São Sebastião da Vargem Alegre", uf11);
		Municipio mun4890 = new Municipio(null, "São Sebastião do Anta", uf11);
		Municipio mun4892 = new Municipio(null, "São Sebastião do Maranhão", uf11);
		Municipio mun4893 = new Municipio(null, "São Sebastião do Oeste", uf11);
		Municipio mun4894 = new Municipio(null, "São Sebastião do Paraíso", uf11);
		Municipio mun4896 = new Municipio(null, "São Sebastião do Rio Preto", uf11);
		Municipio mun4897 = new Municipio(null, "São Sebastião do Rio Verde", uf11);
		Municipio mun4906 = new Municipio(null, "São Thomé das Letras", uf11);
		Municipio mun4907 = new Municipio(null, "São Tiago", uf11);
		Municipio mun4908 = new Municipio(null, "São Tomás de Aquino", uf11);
		Municipio mun4916 = new Municipio(null, "São Vicente de Minas", uf11);
		Municipio mun4930 = new Municipio(null, "Sapucaí-Mirim", uf11);
		Municipio mun4935 = new Municipio(null, "Sardoá", uf11);
		Municipio mun4937 = new Municipio(null, "Sarzedo", uf11);
		Municipio mun4957 = new Municipio(null, "Sem-Peixe", uf11);
		Municipio mun4960 = new Municipio(null, "Senador Amaral", uf11);
		Municipio mun4962 = new Municipio(null, "Senador Cortes", uf11);
		Municipio mun4964 = new Municipio(null, "Senador Firmino", uf11);
		Municipio mun4967 = new Municipio(null, "Senador José Bento", uf11);
		Municipio mun4970 = new Municipio(null, "Senador Modestino Gonçalves", uf11);
		Municipio mun4977 = new Municipio(null, "Senhora de Oliveira", uf11);
		Municipio mun4978 = new Municipio(null, "Senhora do Porto", uf11);
		Municipio mun4979 = new Municipio(null, "Senhora dos Remédios", uf11);
		Municipio mun4983 = new Municipio(null, "Sericita", uf11);
		Municipio mun4987 = new Municipio(null, "Seritinga", uf11);
		Municipio mun4990 = new Municipio(null, "Serra Azul de Minas", uf11);
		Municipio mun4994 = new Municipio(null, "Serra da Saudade", uf11);
		Municipio mun4999 = new Municipio(null, "Serra do Salitre", uf11);
		Municipio mun5000 = new Municipio(null, "Serra dos Aimorés", uf11);
		Municipio mun5011 = new Municipio(null, "Serrania", uf11);
		Municipio mun5013 = new Municipio(null, "Serranópolis de Minas", uf11);
		Municipio mun5016 = new Municipio(null, "Serranos", uf11);
		Municipio mun5022 = new Municipio(null, "Serro", uf11);
		Municipio mun5033 = new Municipio(null, "Sete Lagoas", uf11);
		Municipio mun5035 = new Municipio(null, "Setubinha", uf11);
		Municipio mun5046 = new Municipio(null, "Silveirânia", uf11);
		Municipio mun5049 = new Municipio(null, "Silvianópolis", uf11);
		Municipio mun5051 = new Municipio(null, "Simão Pereira", uf11);
		Municipio mun5055 = new Municipio(null, "Simonésia", uf11);
		Municipio mun5072 = new Municipio(null, "Sobrália", uf11);
		Municipio mun5076 = new Municipio(null, "Soledade de Minas", uf11);
		Municipio mun5113 = new Municipio(null, "Tabuleiro", uf11);
		Municipio mun5123 = new Municipio(null, "Taiobeiras", uf11);
		Municipio mun5144 = new Municipio(null, "Taparuba", uf11);
		Municipio mun5152 = new Municipio(null, "Tapira", uf11);
		Municipio mun5154 = new Municipio(null, "Tapiraí", uf11);
		Municipio mun5160 = new Municipio(null, "Taquaraçu de Minas", uf11);
		Municipio mun5176 = new Municipio(null, "Tarumirim", uf11);
		Municipio mun5187 = new Municipio(null, "Teixeiras", uf11);
		Municipio mun5200 = new Municipio(null, "Teófilo Otoni", uf11);
		Municipio mun5238 = new Municipio(null, "Timóteo", uf11);
		Municipio mun5241 = new Municipio(null, "Tiradentes", uf11);
		Municipio mun5242 = new Municipio(null, "Tiros", uf11);
		Municipio mun5246 = new Municipio(null, "Tocantins", uf11);
		Municipio mun5247 = new Municipio(null, "Tocos do Moji", uf11);
		Municipio mun5248 = new Municipio(null, "Toledo", uf11);
		Municipio mun5252 = new Municipio(null, "Tombos", uf11);
		Municipio mun5277 = new Municipio(null, "Três Corações", uf11);
		Municipio mun5283 = new Municipio(null, "Três Marias", uf11);
		Municipio mun5286 = new Municipio(null, "Três Pontas", uf11);
		Municipio mun5309 = new Municipio(null, "Tumiritinga", uf11);
		Municipio mun5316 = new Municipio(null, "Tupaciguara", uf11);
		Municipio mun5330 = new Municipio(null, "Turmalina", uf11);
		Municipio mun5338 = new Municipio(null, "Turvolândia", uf11);
		Municipio mun5342 = new Municipio(null, "Ubá", uf11);
		Municipio mun5343 = new Municipio(null, "Ubaí", uf11);
		Municipio mun5347 = new Municipio(null, "Ubaporanga", uf11);
		Municipio mun5351 = new Municipio(null, "Uberaba", uf11);
		Municipio mun5352 = new Municipio(null, "Uberlândia", uf11);
		Municipio mun5366 = new Municipio(null, "Umburatiba", uf11);
		Municipio mun5371 = new Municipio(null, "Unaí", uf11);
		Municipio mun5374 = new Municipio(null, "União de Minas", uf11);
		Municipio mun5389 = new Municipio(null, "Uruana de Minas", uf11);
		Municipio mun5394 = new Municipio(null, "Urucânia", uf11);
		Municipio mun5398 = new Municipio(null, "Urucuia", uf11);
		Municipio mun5425 = new Municipio(null, "Vargem Alegre", uf11);
		Municipio mun5427 = new Municipio(null, "Vargem Bonita", uf11);
		Municipio mun5429 = new Municipio(null, "Vargem Grande do Rio Pardo", uf11);
		Municipio mun5435 = new Municipio(null, "Varginha", uf11);
		Municipio mun5436 = new Municipio(null, "Varjão de Minas", uf11);
		Municipio mun5442 = new Municipio(null, "Várzea da Palma", uf11);
		Municipio mun5452 = new Municipio(null, "Varzelândia", uf11);
		Municipio mun5454 = new Municipio(null, "Vazante", uf11);
		Municipio mun5469 = new Municipio(null, "Verdelândia", uf11);
		Municipio mun5472 = new Municipio(null, "Veredinha", uf11);
		Municipio mun5473 = new Municipio(null, "Veríssimo", uf11);
		Municipio mun5474 = new Municipio(null, "Vermelho Novo", uf11);
		Municipio mun5478 = new Municipio(null, "Vespasiano", uf11);
		Municipio mun5489 = new Municipio(null, "Viçosa", uf11);
		Municipio mun5495 = new Municipio(null, "Vieiras", uf11);
		Municipio mun5515 = new Municipio(null, "Virgem da Lapa", uf11);
		Municipio mun5516 = new Municipio(null, "Virgínia", uf11);
		Municipio mun5517 = new Municipio(null, "Virginópolis", uf11);
		Municipio mun5518 = new Municipio(null, "Virgolândia", uf11);
		Municipio mun5520 = new Municipio(null, "Visconde do Rio Branco", uf11);
		Municipio mun5538 = new Municipio(null, "Volta Grande", uf11);
		Municipio mun5546 = new Municipio(null, "Wenceslau Braz", uf11);

		municipioRepository.saveAll(Arrays.asList(mun1001, mun1005, mun1014, mun1039, mun1055, mun1059, mun1062, mun1063, 
			mun1064, mun1067, mun1071, mun1073, mun1078, mun1084, mun1090, mun1093, 
			mun1094, mun1095, mun1098, mun1105, mun1109, mun1124, mun1126, mun1127, 
			mun1128, mun1129, mun1130, mun1131, mun1132, mun1136, mun1143, mun1148, 
			mun114, mun123, mun128, mun130, mun138, mun150, mun155, mun164, 
			mun1153, mun1154, mun1156, mun1159, mun1168, mun1179, mun1185, mun1186, 
			mun1194, mun1199, mun1203, mun1211, mun1218, mun1221, mun1242, mun1243, 
			mun1246, mun1248, mun1261, mun1277, mun1279, mun1280, mun1282, mun1297, 
			mun1318, mun1320, mun1322, mun1324, mun1325, mun1328, mun1329, mun1330, 
			mun1339, mun1340, mun1341, mun1343, mun1355, mun1356, mun1359, mun1360, 
			mun1361, mun1364, mun1365, mun1367, mun1368, mun1370, mun1373, mun1377, 
			mun1384, mun1385, mun1390, mun1392, mun1395, mun1400, mun1407, mun1408, 
			mun1412, mun1413, mun1414, mun1416, mun1417, mun1439, mun1450, mun1454, 
			mun1459, mun1461, mun1463, mun1471, mun1479, mun1487, mun1503, mun1514, 
			mun1524, mun1532, mun1536, mun1537, mun1539, mun1547, mun1548, mun1549, 
			mun1557, mun1562, mun1564, mun1569, mun1570, mun1572, mun1573, mun1577, 
			mun1578, mun1579, mun1580, mun1593, mun1594, mun1599, mun1604, mun1605, 
			mun1609, mun1612, mun1613, mun1614, mun1616, mun1617, mun1622, mun1639, 
			mun1654, mun1666, mun1668, mun1671, mun1672, mun1690, mun1693, mun1694, 
			mun1703, mun1704, mun1715, mun1718, mun1720, mun1723, mun1729, mun1732, 
			mun172, mun177, mun179, mun207, mun230, mun233, mun235, mun260, 
			mun1733, mun1739, mun1740, mun1764, mun1766, mun1767, mun1773, mun1783, 
			mun1784, mun1809, mun1819, mun1827, mun1832, mun1838, mun1847, mun1850, 
			mun1853, mun1855, mun1859, mun1860, mun1861, mun1866, mun1867, mun1869, 
			mun1870, mun1873, mun1877, mun1882, mun1912, mun1921, mun1922, mun1938, 
			mun1940, mun1941, mun1954, mun1966, mun1973, mun1991, mun1992, mun2006, 
			mun2008, mun2013, mun2017, mun2024, mun2030, mun2040, mun2042, mun2044, 
			mun2046, mun2047, mun2055, mun2078, mun2088, mun2089, mun2091, mun2107, 
			mun2108, mun2118, mun2124, mun2125, mun2130, mun2146, mun2151, mun2160, 
			mun2164, mun2174, mun2179, mun2190, mun2191, mun2197, mun2204, mun2210, 
			mun2211, mun2214, mun2218, mun2220, mun2223, mun2230, mun2254, mun2262, 
			mun2292, mun2293, mun2294, mun2298, mun2299, mun2312, mun2322, mun2332, 
			mun2336, mun2337, mun2340, mun2342, mun2346, mun2347, mun2350, mun2353, 
			mun2354, mun2359, mun2364, mun2374, mun2414, mun2421, mun2428, mun2429, 
			mun2431, mun2442, mun2443, mun2445, mun2449, mun2450, mun2469, mun2480, 
			mun2483, mun2488, mun2492, mun2505, mun2509, mun2510, mun2519, mun2521, 
			mun2528, mun2563, mun2564, mun2566, mun2569, mun2570, mun2571, mun2577, 
			mun2585, mun2586, mun2594, mun2597, mun2599, mun2607, mun2613, mun2614, 
			mun2616, mun2621, mun2631, mun2648, mun2655, mun2666, mun2670, mun2673, 
			mun262, mun267, mun294, mun302, mun308, mun320, mun329, mun333, 
			mun2685, mun2699, mun2701, mun2702, mun2704, mun2709, mun2732, mun2735, 
			mun2736, mun2743, mun2747, mun2756, mun2758, mun2760, mun2765, mun2769, 
			mun2773, mun2774, mun2794, mun2811, mun2812, mun2816, mun2821, mun2840, 
			mun2843, mun2850, mun2869, mun2879, mun2892, mun2895, mun2896, mun2904, 
			mun2907, mun2934, mun2949, mun2953, mun2959, mun2967, mun2969, mun2973, 
			mun2975, mun2978, mun2981, mun2994, mun3000, mun3001, mun3002, mun3003, 
			mun3, mun5, mun14, mun17, mun31, mun47, mun53, mun64, 
			mun3004, mun3010, mun3016, mun3020, mun3025, mun3036, mun3039, mun3042, 
			mun3046, mun3050, mun3069, mun3070, mun3075, mun3081, mun3083, mun3098, 
			mun3106, mun3107, mun3121, mun3124, mun3127, mun3132, mun3142, mun3144, 
			mun3146, mun3151, mun3155, mun3158, mun3165, mun3166, mun3169, mun3185, 
			mun3188, mun3216, mun3221, mun3229, mun3231, mun3232, mun3234, mun3236, 
			mun3239, mun3240, mun3252, mun3256, mun3265, mun3297, mun3312, mun3338, 
			mun3344, mun3359, mun3360, mun3365, mun3375, mun3381, mun3396, mun3410, 
			mun335, mun337, mun359, mun360, mun361, mun363, mun365, mun378, 
			mun3422, mun3430, mun3439, mun3441, mun3448, mun3449, mun3451, mun3453, 
			mun3457, mun3476, mun3479, mun3481, mun3484, mun3502, mun3504, mun3506, 
			mun3510, mun3512, mun3513, mun3522, mun3550, mun3559, mun3562, mun3564, 
			mun3568, mun3579, mun3597, mun3623, mun3625, mun3626, mun3631, mun3638, 
			mun3640, mun3643, mun3646, mun3648, mun3658, mun3667, mun3675, mun3680, 
			mun3682, mun3684, mun3688, mun3689, mun3690, mun3697, mun3702, mun3709, 
			mun3719, mun3722, mun3736, mun3737, mun3739, mun3740, mun3741, mun3746, 
			mun3754, mun3765, mun3771, mun3772, mun3773, mun3774, mun3786, mun3797, 
			mun379, mun380, mun415, mun421, mun426, mun452, mun464, mun474, 
			mun3815, mun3823, mun3830, mun3833, mun3835, mun3836, mun3840, mun3843, 
			mun3851, mun3862, mun3866, mun3878, mun3889, mun3894, mun3895, mun3902, 
			mun3918, mun3924, mun3925, mun3937, mun3958, mun3978, mun3984, mun3985, 
			mun3994, mun4001, mun4004, mun4005, mun4007, mun4018, mun4022, mun4027, 
			mun4046, mun4054, mun4071, mun4102, mun4103, mun4107, mun4114, mun4124, 
			mun4129, mun4130, mun4141, mun4149, mun4166, mun4174, mun4182, mun4193, 
			mun4209, mun4211, mun4215, mun4222, mun4228, mun4229, mun4230, mun4232, 
			mun4233, mun4235, mun4243, mun4247, mun4250, mun4254, mun4262, mun4274, 
			mun4282, mun4285, mun4291, mun4294, mun4296, mun4312, mun4319, mun4345, 
			mun4346, mun4349, mun4350, mun4368, mun4370, mun4373, mun4382, mun4385, 
			mun4394, mun4409, mun4420, mun4424, mun4429, mun4435, mun4436, mun4447, 
			mun4449, mun4450, mun4451, mun4453, mun4457, mun4462, mun4488, mun4492, 
			mun4493, mun4496, mun4500, mun4501, mun4504, mun4506, mun4510, mun4512, 
			mun4516, mun4544, mun4546, mun4549, mun4551, mun4552, mun4556, mun4561, 
			mun4562, mun4573, mun4577, mun4583, mun4597, mun4609, mun4617, mun4626, 
			mun4639, mun4641, mun4644, mun4651, mun4660, mun4662, mun4663, mun4664, 
			mun4668, mun4670, mun4671, mun4672, mun4675, mun4678, mun4687, mun4688, 
			mun4691, mun4696, mun4700, mun4709, mun4710, mun4712, mun4713, mun4715, 
			mun4726, mun4727, mun4731, mun4738, mun4744, mun4745, mun4747, mun4758, 
			mun4767, mun4770, mun4775, mun4776, mun4805, mun4834, mun4858, mun4866, 
			mun478, mun479, mun487, mun491, mun496, mun532, mun556, mun572, 
			mun4870, mun4878, mun4879, mun4884, mun4887, mun4890, mun4892, mun4893, 
			mun4894, mun4896, mun4897, mun4906, mun4907, mun4908, mun4916, mun4930, 
			mun4935, mun4937, mun4957, mun4960, mun4962, mun4964, mun4967, mun4970, 
			mun4977, mun4978, mun4979, mun4983, mun4987, mun4990, mun4994, mun4999, 
			mun5000, mun5011, mun5013, mun5016, mun5022, mun5033, mun5035, mun5046, 
			mun5049, mun5051, mun5055, mun5072, mun5076, mun5113, mun5123, mun5144, 
			mun5152, mun5154, mun5160, mun5176, mun5187, mun5200, mun5238, mun5241, 
			mun5242, mun5246, mun5247, mun5248, mun5252, mun5277, mun5283, mun5286, 
			mun5309, mun5316, mun5330, mun5338, mun5342, mun5343, mun5347, mun5351, 
			mun5352, mun5366, mun5371, mun5374, mun5389, mun5394, mun5398, mun5425, 
			mun5427, mun5429, mun5435, mun5436, mun5442, mun5452, mun5454, mun5469, 
			mun5472, mun5473, mun5474, mun5478, mun5489, mun5495, mun5515, mun5516, 
			mun5517, mun5518, mun5520, mun5538, mun5546, 
			mun587, mun591, mun594, mun595, mun607, mun608, mun615, mun619, 
			mun621, mun622, mun625, mun633, mun654, mun659, mun666, mun669, 
			mun674, mun678, mun680, mun697, mun702, mun707, mun709, mun712, 
			mun71, mun75, mun82, mun85, mun89, mun95, mun107, mun111, 
			mun729, mun733, mun735, mun746, mun748, mun754, mun757, mun759, 
			mun785, mun789, mun790, mun793, mun810, mun813, mun821, mun828, 
			mun839, mun841, mun842, mun847, mun867, mun869, mun878, mun900, 
			mun906, mun915, mun918, mun929, mun930, mun934, mun935, mun939, 
			mun947, mun959, mun961, mun966, mun969, mun986, mun992, mun999));

	}
	
	private void instanciaMunUf12(UF uf12) {
		Municipio mun52 = new Municipio(null, "Água Clara", uf12);
		Municipio mun99 = new Municipio(null, "Alcinópolis", uf12);
		Municipio mun186 = new Municipio(null, "Amambaí", uf12);
		Municipio mun223 = new Municipio(null, "Anastácio", uf12);
		Municipio mun224 = new Municipio(null, "Anaurilândia", uf12);
		Municipio mun236 = new Municipio(null, "Angélica", uf12);
		Municipio mun264 = new Municipio(null, "Antônio João", uf12);
		Municipio mun273 = new Municipio(null, "Aparecida do Taboado", uf12);
		Municipio mun290 = new Municipio(null, "Aquidauana", uf12);
		Municipio mun323 = new Municipio(null, "Aral Moreira", uf12);
		Municipio mun482 = new Municipio(null, "Bandeirantes", uf12);
		Municipio mun559 = new Municipio(null, "Bataguassu", uf12);
		Municipio mun560 = new Municipio(null, "Bataiporã", uf12);
		Municipio mun577 = new Municipio(null, "Bela Vista", uf12);
		Municipio mun662 = new Municipio(null, "Bodoquena", uf12);
		Municipio mun714 = new Municipio(null, "Bonito", uf12);
		Municipio mun751 = new Municipio(null, "Brasilândia", uf12);
		Municipio mun817 = new Municipio(null, "Caarapó", uf12);
		Municipio mun919 = new Municipio(null, "Camapuã", uf12);
		Municipio mun972 = new Municipio(null, "Campo Grande", uf12);
		Municipio mun1087 = new Municipio(null, "Caracol", uf12);
		Municipio mun1169 = new Municipio(null, "Cassilândia", uf12);
		Municipio mun1252 = new Municipio(null, "Chapadão do Sul", uf12);
		Municipio mun1388 = new Municipio(null, "Corguinho", uf12);
		Municipio mun1410 = new Municipio(null, "Coronel Sapucaia", uf12);
		Municipio mun1424 = new Municipio(null, "Corumbá", uf12);
		Municipio mun1434 = new Municipio(null, "Costa Rica", uf12);
		Municipio mun1442 = new Municipio(null, "Coxim", uf12);
		Municipio mun1542 = new Municipio(null, "Deodápolis", uf12);
		Municipio mun1584 = new Municipio(null, "Dois Irmãos do Buriti", uf12);
		Municipio mun1619 = new Municipio(null, "Douradina", uf12);
		Municipio mun1623 = new Municipio(null, "Dourados", uf12);
		Municipio mun1647 = new Municipio(null, "Eldorado", uf12);
		Municipio mun1747 = new Municipio(null, "Fátima do Sul", uf12);
		Municipio mun1786 = new Municipio(null, "Figueirão", uf12);
		Municipio mun1915 = new Municipio(null, "Glória de Dourados", uf12);
		Municipio mun2041 = new Municipio(null, "Guia Lopes da Laguna", uf12);
		Municipio mun2161 = new Municipio(null, "Iguatemi", uf12);
		Municipio mun2215 = new Municipio(null, "Inocência", uf12);
		Municipio mun2391 = new Municipio(null, "Itaporã", uf12);
		Municipio mun2404 = new Municipio(null, "Itaquiraí", uf12);
		Municipio mun2458 = new Municipio(null, "Ivinhema", uf12);
		Municipio mun2529 = new Municipio(null, "Japorã", uf12);
		Municipio mun2536 = new Municipio(null, "Jaraguari", uf12);
		Municipio mun2544 = new Municipio(null, "Jardim", uf12);
		Municipio mun2554 = new Municipio(null, "Jateí", uf12);
		Municipio mun2665 = new Municipio(null, "Juti", uf12);
		Municipio mun2671 = new Municipio(null, "Ladário", uf12);
		Municipio mun2717 = new Municipio(null, "Laguna Carapã", uf12);
		Municipio mun2916 = new Municipio(null, "Maracaju", uf12);
		Municipio mun3086 = new Municipio(null, "Miranda", uf12);
		Municipio mun3212 = new Municipio(null, "Mundo Novo", uf12);
		Municipio mun3246 = new Municipio(null, "Naviraí", uf12);
		Municipio mun3266 = new Municipio(null, "Nioaque", uf12);
		Municipio mun3287 = new Municipio(null, "Nova Alvorada do Sul", uf12);
		Municipio mun3291 = new Municipio(null, "Nova Andradina", uf12);
		Municipio mun3401 = new Municipio(null, "Novo Horizonte do Sul", uf12);
		Municipio mun3587 = new Municipio(null, "Paranaíba", uf12);
		Municipio mun3596 = new Municipio(null, "Paranhos", uf12);
		Municipio mun3716 = new Municipio(null, "Pedro Gomes", uf12);
		Municipio mun3906 = new Municipio(null, "Ponta Porã", uf12);
		Municipio mun3963 = new Municipio(null, "Porto Murtinho", uf12);
		Municipio mun4156 = new Municipio(null, "Ribas do Rio Pardo", uf12);
		Municipio mun4192 = new Municipio(null, "Rio Brilhante", uf12);
		Municipio mun4225 = new Municipio(null, "Rio Negro", uf12);
		Municipio mun4241 = new Municipio(null, "Rio Verde de Mato Grosso", uf12);
		Municipio mun4251 = new Municipio(null, "Rochedo", uf12);
		Municipio mun4455 = new Municipio(null, "Santa Rita do Pardo", uf12);
		Municipio mun4657 = new Municipio(null, "São Gabriel do Oeste", uf12);
		Municipio mun4956 = new Municipio(null, "Selvíria", uf12);
		Municipio mun5034 = new Municipio(null, "Sete Quedas", uf12);
		Municipio mun5040 = new Municipio(null, "Sidrolândia", uf12);
		Municipio mun5082 = new Municipio(null, "Sonora", uf12);
		Municipio mun5117 = new Municipio(null, "Tacuru", uf12);
		Municipio mun5170 = new Municipio(null, "Taquarussu", uf12);
		Municipio mun5203 = new Municipio(null, "Terenos", uf12);
		Municipio mun5282 = new Municipio(null, "Três Lagoas", uf12);
		Municipio mun5486 = new Municipio(null, "Vicentina", uf12);

		municipioRepository.saveAll(Arrays.asList(mun1410, mun1424, mun1434, mun1442, mun1542, mun1584, mun1619, mun1623, 
			mun1647, mun1747, mun1786, mun1915, mun2041, mun2161, mun2215, mun2391, 
			mun2404, mun2458, mun2529, mun2536, mun2544, mun2554, mun2665, mun2671, 
			mun2717, mun2916, mun3086, mun3212, mun3246, mun3266, mun3287, mun3291, 
			mun290, mun323, mun482, mun559, mun560, mun577, mun662, mun714, 
			mun3401, mun3587, mun3596, mun3716, mun3906, mun3963, mun4156, mun4192, 
			mun4225, mun4241, mun4251, mun4455, mun4657, mun4956, mun5034, mun5040, 
			mun5082, mun5117, mun5170, mun5203, mun5282, mun5486, 
			mun52, mun99, mun186, mun223, mun224, mun236, mun264, mun273, 
			mun751, mun817, mun919, mun972, mun1087, mun1169, mun1252, mun1388));

	}
	
	private void instanciaMunUf13(UF uf13) {
		Municipio mun27 = new Municipio(null, "Acorizal", uf13);
		Municipio mun48 = new Municipio(null, "Água Boa", uf13);
		Municipio mun132 = new Municipio(null, "Alta Floresta", uf13);
		Municipio mun147 = new Municipio(null, "Alto Araguaia", uf13);
		Municipio mun149 = new Municipio(null, "Alto Boa Vista", uf13);
		Municipio mun153 = new Municipio(null, "Alto Garças", uf13);
		Municipio mun157 = new Municipio(null, "Alto Paraguai", uf13);
		Municipio mun167 = new Municipio(null, "Alto Taquari", uf13);
		Municipio mun278 = new Municipio(null, "Apiacás", uf13);
		Municipio mun314 = new Municipio(null, "Araguaiana", uf13);
		Municipio mun316 = new Municipio(null, "Araguainha", uf13);
		Municipio mun339 = new Municipio(null, "Araputanga", uf13);
		Municipio mun375 = new Municipio(null, "Arenápolis", uf13);
		Municipio mun381 = new Municipio(null, "Aripuanã", uf13);
		Municipio mun490 = new Municipio(null, "Barão de Melgaço", uf13);
		Municipio mun515 = new Municipio(null, "Barra do Bugres", uf13);
		Municipio mun519 = new Municipio(null, "Barra do Garças", uf13);
		Municipio mun679 = new Municipio(null, "Bom Jesus do Araguaia", uf13);
		Municipio mun756 = new Municipio(null, "Brasnorte", uf13);
		Municipio mun837 = new Municipio(null, "Cáceres", uf13);
		Municipio mun949 = new Municipio(null, "Campinápolis", uf13);
		Municipio mun982 = new Municipio(null, "Campo Novo do Parecis", uf13);
		Municipio mun985 = new Municipio(null, "Campo Verde", uf13);
		Municipio mun989 = new Municipio(null, "Campos de Júlio", uf13);
		Municipio mun1002 = new Municipio(null, "Canabrava do Norte", uf13);
		Municipio mun1007 = new Municipio(null, "Canarana", uf13);
		Municipio mun1121 = new Municipio(null, "Carlinda", uf13);
		Municipio mun1171 = new Municipio(null, "Castanheira", uf13);
		Municipio mun1247 = new Municipio(null, "Chapada dos Guimarães", uf13);
		Municipio mun1281 = new Municipio(null, "Cláudia", uf13);
		Municipio mun1291 = new Municipio(null, "Cocalinho", uf13);
		Municipio mun1302 = new Municipio(null, "Colíder", uf13);
		Municipio mun1309 = new Municipio(null, "Colniza", uf13);
		Municipio mun1323 = new Municipio(null, "Comodoro", uf13);
		Municipio mun1357 = new Municipio(null, "Confresa", uf13);
		Municipio mun1363 = new Municipio(null, "Conquista d'Oeste", uf13);
		Municipio mun1438 = new Municipio(null, "Cotriguaçu", uf13);
		Municipio mun1491 = new Municipio(null, "Cuiabá", uf13);
		Municipio mun1522 = new Municipio(null, "Curvelândia", uf13);
		Municipio mun1523 = new Municipio(null, "Curvelândia", uf13);
		Municipio mun1541 = new Municipio(null, "Denise", uf13);
		Municipio mun1558 = new Municipio(null, "Diamantino", uf13);
		Municipio mun1591 = new Municipio(null, "Dom Aquino", uf13);
		Municipio mun1769 = new Municipio(null, "Feliz Natal", uf13);
		Municipio mun1787 = new Municipio(null, "Figueirópolis d'Oeste", uf13);
		Municipio mun1894 = new Municipio(null, "Gaúcha do Norte", uf13);
		Municipio mun1900 = new Municipio(null, "General Carneiro", uf13);
		Municipio mun1914 = new Municipio(null, "Glória d'Oeste", uf13);
		Municipio mun2019 = new Municipio(null, "Guarantã do Norte", uf13);
		Municipio mun2045 = new Municipio(null, "Guiratinga", uf13);
		Municipio mun2202 = new Municipio(null, "Indiavaí", uf13);
		Municipio mun2236 = new Municipio(null, "Ipiranga do Norte", uf13);
		Municipio mun2351 = new Municipio(null, "Itanhangá", uf13);
		Municipio mun2423 = new Municipio(null, "Itaúba", uf13);
		Municipio mun2432 = new Municipio(null, "Itiquira", uf13);
		Municipio mun2478 = new Municipio(null, "Jaciara", uf13);
		Municipio mun2517 = new Municipio(null, "Jangada", uf13);
		Municipio mun2562 = new Municipio(null, "Jauru", uf13);
		Municipio mun2618 = new Municipio(null, "Juara", uf13);
		Municipio mun2630 = new Municipio(null, "Juína", uf13);
		Municipio mun2656 = new Municipio(null, "Juruena", uf13);
		Municipio mun2658 = new Municipio(null, "Juscimeira", uf13);
		Municipio mun2734 = new Municipio(null, "Lambari d'Oeste", uf13);
		Municipio mun2800 = new Municipio(null, "Lucas do Rio Verde", uf13);
		Municipio mun2804 = new Municipio(null, "Luciára", uf13);
		Municipio mun2936 = new Municipio(null, "Marcelândia", uf13);
		Municipio mun3023 = new Municipio(null, "Matupá", uf13);
		Municipio mun3095 = new Municipio(null, "Mirassol d'Oeste", uf13);
		Municipio mun3271 = new Municipio(null, "Nobres", uf13);
		Municipio mun3275 = new Municipio(null, "Nortelândia", uf13);
		Municipio mun3282 = new Municipio(null, "Nossa Senhora do Livramento", uf13);
		Municipio mun3295 = new Municipio(null, "Nova Bandeirantes", uf13);
		Municipio mun3300 = new Municipio(null, "Nova Brasilândia", uf13);
		Municipio mun3303 = new Municipio(null, "Nova Canaã do Norte", uf13);
		Municipio mun3325 = new Municipio(null, "Nova Guarita", uf13);
		Municipio mun3336 = new Municipio(null, "Nova Lacerda", uf13);
		Municipio mun3342 = new Municipio(null, "Nova Marilândia", uf13);
		Municipio mun3343 = new Municipio(null, "Nova Maringá", uf13);
		Municipio mun3345 = new Municipio(null, "Nova Monte verde", uf13);
		Municipio mun3346 = new Municipio(null, "Nova Mutum", uf13);
		Municipio mun3348 = new Municipio(null, "Nova Olímpia", uf13);
		Municipio mun3371 = new Municipio(null, "Nova Santa Helena", uf13);
		Municipio mun3380 = new Municipio(null, "Nova Ubiratã", uf13);
		Municipio mun3387 = new Municipio(null, "Nova Xavantina", uf13);
		Municipio mun3399 = new Municipio(null, "Novo Horizonte do Norte", uf13);
		Municipio mun3409 = new Municipio(null, "Novo Mundo", uf13);
		Municipio mun3416 = new Municipio(null, "Novo Santo Antônio", uf13);
		Municipio mun3418 = new Municipio(null, "Novo São Joaquim", uf13);
		Municipio mun3589 = new Municipio(null, "Paranaíta", uf13);
		Municipio mun3594 = new Municipio(null, "Paranatinga", uf13);
		Municipio mun3694 = new Municipio(null, "Pedra Preta", uf13);
		Municipio mun3726 = new Municipio(null, "Peixoto de Azevedo", uf13);
		Municipio mun3873 = new Municipio(null, "Planalto da Serra", uf13);
		Municipio mun3893 = new Municipio(null, "Poconé", uf13);
		Municipio mun3907 = new Municipio(null, "Pontal do Araguaia", uf13);
		Municipio mun3917 = new Municipio(null, "Ponte Branca", uf13);
		Municipio mun3921 = new Municipio(null, "Pontes e Lacerda", uf13);
		Municipio mun3941 = new Municipio(null, "Porto Alegre do Norte", uf13);
		Municipio mun3953 = new Municipio(null, "Porto dos Gaúchos", uf13);
		Municipio mun3954 = new Municipio(null, "Porto Esperidião", uf13);
		Municipio mun3955 = new Municipio(null, "Porto Estrela", uf13);
		Municipio mun3988 = new Municipio(null, "Poxoréo", uf13);
		Municipio mun4034 = new Municipio(null, "Primavera do Leste", uf13);
		Municipio mun4073 = new Municipio(null, "Querência", uf13);
		Municipio mun4126 = new Municipio(null, "Reserva do Cabaçal", uf13);
		Municipio mun4163 = new Municipio(null, "Ribeirão Cascalheira", uf13);
		Municipio mun4176 = new Municipio(null, "Ribeirãozinho", uf13);
		Municipio mun4191 = new Municipio(null, "Rio Branco", uf13);
		Municipio mun4267 = new Municipio(null, "Rondolândia", uf13);
		Municipio mun4270 = new Municipio(null, "Rondonópolis", uf13);
		Municipio mun4278 = new Municipio(null, "Rosário Oeste", uf13);
		Municipio mun4321 = new Municipio(null, "Salto do Céu", uf13);
		Municipio mun4354 = new Municipio(null, "Santa Carmem", uf13);
		Municipio mun4377 = new Municipio(null, "Santa Cruz do Xingu", uf13);
		Municipio mun4459 = new Municipio(null, "Santa Rita do Trivelato", uf13);
		Municipio mun4484 = new Municipio(null, "Santa Terezinha", uf13);
		Municipio mun4525 = new Municipio(null, "Santo Afonso", uf13);
		Municipio mun4554 = new Municipio(null, "Santo Antônio do Leste", uf13);
		Municipio mun4555 = new Municipio(null, "Santo Antônio do Leverger", uf13);
		Municipio mun4627 = new Municipio(null, "São Félix do Araguaia", uf13);
		Municipio mun4781 = new Municipio(null, "São José do Povo", uf13);
		Municipio mun4782 = new Municipio(null, "São José do Rio Claro", uf13);
		Municipio mun4789 = new Municipio(null, "São José do Xingu", uf13);
		Municipio mun4795 = new Municipio(null, "São José dos Quatro Marcos", uf13);
		Municipio mun4856 = new Municipio(null, "São Pedro da Cipa", uf13);
		Municipio mun4924 = new Municipio(null, "Sapezal", uf13);
		Municipio mun5005 = new Municipio(null, "Serra Nova Dourada", uf13);
		Municipio mun5058 = new Municipio(null, "Sinop", uf13);
		Municipio mun5085 = new Municipio(null, "Sorriso", uf13);
		Municipio mun5104 = new Municipio(null, "Tabaporã", uf13);
		Municipio mun5135 = new Municipio(null, "Tangará da Serra", uf13);
		Municipio mun5158 = new Municipio(null, "Tapurah", uf13);
		Municipio mun5212 = new Municipio(null, "Terra Nova do Norte", uf13);
		Municipio mun5219 = new Municipio(null, "Tesouro", uf13);
		Municipio mun5256 = new Municipio(null, "Torixoréu", uf13);
		Municipio mun5376 = new Municipio(null, "União do Sul", uf13);
		Municipio mun5409 = new Municipio(null, "Vale de São Domingos", uf13);
		Municipio mun5445 = new Municipio(null, "Várzea Grande", uf13);
		Municipio mun5466 = new Municipio(null, "Vera", uf13);
		Municipio mun5498 = new Municipio(null, "Vila Bela da Santíssima Trindade", uf13);
		Municipio mun5509 = new Municipio(null, "Vila Rica", uf13);

		municipioRepository.saveAll(Arrays.asList(mun1002, mun1007, mun1121, mun1171, mun1247, mun1281, mun1291, mun1302, 
			mun1309, mun1323, mun1357, mun1363, mun1438, mun1491, mun1522, mun1523, 
			mun1541, mun1558, mun1591, mun1769, mun1787, mun1894, mun1900, mun1914, 
			mun2019, mun2045, mun2202, mun2236, mun2351, mun2423, mun2432, mun2478, 
			mun2517, mun2562, mun2618, mun2630, mun2656, mun2658, mun2734, mun2800, 
			mun27, mun48, mun132, mun147, mun149, mun153, mun157, mun167, 
			mun278, mun314, mun316, mun339, mun375, mun381, mun490, mun515, 
			mun2804, mun2936, mun3023, mun3095, mun3271, mun3275, mun3282, mun3295, 
			mun3300, mun3303, mun3325, mun3336, mun3342, mun3343, mun3345, mun3346, 
			mun3348, mun3371, mun3380, mun3387, mun3399, mun3409, mun3416, mun3418, 
			mun3589, mun3594, mun3694, mun3726, mun3873, mun3893, mun3907, mun3917, 
			mun3921, mun3941, mun3953, mun3954, mun3955, mun3988, mun4034, mun4073, 
			mun4126, mun4163, mun4176, mun4191, mun4267, mun4270, mun4278, mun4321, 
			mun4354, mun4377, mun4459, mun4484, mun4525, mun4554, mun4555, mun4627, 
			mun4781, mun4782, mun4789, mun4795, mun4856, mun4924, mun5005, mun5058, 
			mun5085, mun5104, mun5135, mun5158, mun5212, mun5219, mun5256, mun5376, 
			mun519, mun679, mun756, mun837, mun949, mun982, mun985, mun989, 
			mun5409, mun5445, mun5466, mun5498, mun5509));

	}
	
	private void instanciaMunUf14(UF uf14) {
		Municipio mun6 = new Municipio(null, "Abaetetuba", uf14);
		Municipio mun12 = new Municipio(null, "Abel Figueiredo", uf14);
		Municipio mun20 = new Municipio(null, "Acará", uf14);
		Municipio mun41 = new Municipio(null, "Afuá", uf14);
		Municipio mun46 = new Municipio(null, "Água Azul do Norte", uf14);
		Municipio mun108 = new Municipio(null, "Alenquer", uf14);
		Municipio mun122 = new Municipio(null, "Almeirim", uf14);
		Municipio mun136 = new Municipio(null, "Altamira", uf14);
		Municipio mun214 = new Municipio(null, "Anajás", uf14);
		Municipio mun219 = new Municipio(null, "Ananindeua", uf14);
		Municipio mun221 = new Municipio(null, "Anapu", uf14);
		Municipio mun425 = new Municipio(null, "Augusto Corrêa", uf14);
		Municipio mun433 = new Municipio(null, "Aurora do Pará", uf14);
		Municipio mun441 = new Municipio(null, "Aveiro", uf14);
		Municipio mun454 = new Municipio(null, "Bagre", uf14);
		Municipio mun458 = new Municipio(null, "Baião", uf14);
		Municipio mun484 = new Municipio(null, "Bannach", uf14);
		Municipio mun500 = new Municipio(null, "Barcarena", uf14);
		Municipio mun583 = new Municipio(null, "Belém", uf14);
		Municipio mun596 = new Municipio(null, "Belterra", uf14);
		Municipio mun600 = new Municipio(null, "Benevides", uf14);
		Municipio mun685 = new Municipio(null, "Bom Jesus do Tocantins", uf14);
		Municipio mun715 = new Municipio(null, "Bonito", uf14);
		Municipio mun743 = new Municipio(null, "Bragança", uf14);
		Municipio mun747 = new Municipio(null, "Brasil Novo", uf14);
		Municipio mun772 = new Municipio(null, "Brejo Grande do Araguaia", uf14);
		Municipio mun778 = new Municipio(null, "Breu Branco", uf14);
		Municipio mun779 = new Municipio(null, "Breves", uf14);
		Municipio mun796 = new Municipio(null, "Bujaru", uf14);
		Municipio mun843 = new Municipio(null, "Cachoeira do Arari", uf14);
		Municipio mun844 = new Municipio(null, "Cachoeira do Piriá", uf14);
		Municipio mun931 = new Municipio(null, "Cametá", uf14);
		Municipio mun1000 = new Municipio(null, "Canaã dos Carajás", uf14);
		Municipio mun1047 = new Municipio(null, "Capanema", uf14);
		Municipio mun1076 = new Municipio(null, "Capitão Poço", uf14);
		Municipio mun1170 = new Municipio(null, "Castanhal", uf14);
		Municipio mun1260 = new Municipio(null, "Chaves", uf14);
		Municipio mun1300 = new Municipio(null, "Colares", uf14);
		Municipio mun1333 = new Municipio(null, "Conceição do Araguaia", uf14);
		Municipio mun1347 = new Municipio(null, "Concórdia do Pará", uf14);
		Municipio mun1497 = new Municipio(null, "Cumaru do Norte", uf14);
		Municipio mun1507 = new Municipio(null, "Curionópolis", uf14);
		Municipio mun1517 = new Municipio(null, "Curralinho", uf14);
		Municipio mun1519 = new Municipio(null, "Curuá", uf14);
		Municipio mun1520 = new Municipio(null, "Curuçá", uf14);
		Municipio mun1595 = new Municipio(null, "Dom Eliseu", uf14);
		Municipio mun1646 = new Municipio(null, "Eldorado dos Carajás", uf14);
		Municipio mun1742 = new Municipio(null, "Faro", uf14);
		Municipio mun1805 = new Municipio(null, "Floresta do Araguaia", uf14);
		Municipio mun1889 = new Municipio(null, "Garrafão do Norte", uf14);
		Municipio mun1926 = new Municipio(null, "Goianésia do Pará", uf14);
		Municipio mun2050 = new Municipio(null, "Gurupá", uf14);
		Municipio mun2147 = new Municipio(null, "Igarapé-Açu", uf14);
		Municipio mun2148 = new Municipio(null, "Igarapé-Miri", uf14);
		Municipio mun2208 = new Municipio(null, "Inhangapi", uf14);
		Municipio mun2240 = new Municipio(null, "Ipixuna do Pará", uf14);
		Municipio mun2278 = new Municipio(null, "Irituia", uf14);
		Municipio mun2325 = new Municipio(null, "Itaituba", uf14);
		Municipio mun2447 = new Municipio(null, "Itupiranga", uf14);
		Municipio mun2474 = new Municipio(null, "Jacareacanga", uf14);
		Municipio mun2486 = new Municipio(null, "Jacundá", uf14);
		Municipio mun2657 = new Municipio(null, "Juruti", uf14);
		Municipio mun2777 = new Municipio(null, "Limoeiro do Ajuru", uf14);
		Municipio mun2853 = new Municipio(null, "Mãe do Rio", uf14);
		Municipio mun2856 = new Municipio(null, "Magalhães Barata", uf14);
		Municipio mun2912 = new Municipio(null, "Marabá", uf14);
		Municipio mun2917 = new Municipio(null, "Maracanã", uf14);
		Municipio mun2926 = new Municipio(null, "Marapanim", uf14);
		Municipio mun2971 = new Municipio(null, "Marituba", uf14);
		Municipio mun3038 = new Municipio(null, "Medicilândia", uf14);
		Municipio mun3041 = new Municipio(null, "Melgaço", uf14);
		Municipio mun3103 = new Municipio(null, "Mocajuba", uf14);
		Municipio mun3114 = new Municipio(null, "Moju", uf14);
		Municipio mun3137 = new Municipio(null, "Monte Alegre", uf14);
		Municipio mun3200 = new Municipio(null, "Muaná", uf14);
		Municipio mun3314 = new Municipio(null, "Nova Esperança do Piriá", uf14);
		Municipio mun3333 = new Municipio(null, "Nova Ipixuna", uf14);
		Municipio mun3378 = new Municipio(null, "Nova Timboteua", uf14);
		Municipio mun3414 = new Municipio(null, "Novo Progresso", uf14);
		Municipio mun3415 = new Municipio(null, "Novo Repartimento", uf14);
		Municipio mun3424 = new Municipio(null, "Óbidos", uf14);
		Municipio mun3427 = new Municipio(null, "Oeiras do Pará", uf14);
		Municipio mun3456 = new Municipio(null, "Oriximiná", uf14);
		Municipio mun3470 = new Municipio(null, "Ourém", uf14);
		Municipio mun3473 = new Municipio(null, "Ourilândia do Norte", uf14);
		Municipio mun3493 = new Municipio(null, "Pacajá", uf14);
		Municipio mun3516 = new Municipio(null, "Palestina do Pará", uf14);
		Municipio mun3566 = new Municipio(null, "Paragominas", uf14);
		Municipio mun3603 = new Municipio(null, "Parauapebas", uf14);
		Municipio mun3653 = new Municipio(null, "Pau d'Arco", uf14);
		Municipio mun3725 = new Municipio(null, "Peixe-Boi", uf14);
		Municipio mun3767 = new Municipio(null, "Piçarra", uf14);
		Municipio mun3867 = new Municipio(null, "Placas", uf14);
		Municipio mun3904 = new Municipio(null, "Ponta de Pedras", uf14);
		Municipio mun3938 = new Municipio(null, "Portel", uf14);
		Municipio mun3950 = new Municipio(null, "Porto de Moz", uf14);
		Municipio mun3998 = new Municipio(null, "Prainha", uf14);
		Municipio mun4035 = new Municipio(null, "Primavera", uf14);
		Municipio mun4058 = new Municipio(null, "Quatipuru", uf14);
		Municipio mun4111 = new Municipio(null, "Redenção", uf14);
		Municipio mun4223 = new Municipio(null, "Rio Maria", uf14);
		Municipio mun4268 = new Municipio(null, "Rondon do Pará", uf14);
		Municipio mun4287 = new Municipio(null, "Rurópolis", uf14);
		Municipio mun4313 = new Municipio(null, "Salinópolis", uf14);
		Municipio mun4331 = new Municipio(null, "Salvaterra", uf14);
		Municipio mun4347 = new Municipio(null, "Santa Bárbara do Pará", uf14);
		Municipio mun4371 = new Municipio(null, "Santa Cruz do Arari", uf14);
		Municipio mun4404 = new Municipio(null, "Santa Isabel do Pará", uf14);
		Municipio mun4417 = new Municipio(null, "Santa Luzia do Pará", uf14);
		Municipio mun4428 = new Municipio(null, "Santa Maria das Barreiras", uf14);
		Municipio mun4434 = new Municipio(null, "Santa Maria do Pará", uf14);
		Municipio mun4498 = new Municipio(null, "Santana do Araguaia", uf14);
		Municipio mun4520 = new Municipio(null, "Santarém Novo", uf14);
		Municipio mun4521 = new Municipio(null, "Santarém", uf14);
		Municipio mun4564 = new Municipio(null, "Santo Antônio do Tauá", uf14);
		Municipio mun4600 = new Municipio(null, "São Caetano de Odivelas", uf14);
		Municipio mun4611 = new Municipio(null, "São Domingos do Araguaia", uf14);
		Municipio mun4613 = new Municipio(null, "São Domingos do Capim", uf14);
		Municipio mun4631 = new Municipio(null, "São Félix do Xingu", uf14);
		Municipio mun4648 = new Municipio(null, "São Francisco do Pará", uf14);
		Municipio mun4661 = new Municipio(null, "São Geraldo do Araguaia", uf14);
		Municipio mun4690 = new Municipio(null, "São João da Ponta", uf14);
		Municipio mun4699 = new Municipio(null, "São João de Pirabas", uf14);
		Municipio mun4701 = new Municipio(null, "São João do Araguaia", uf14);
		Municipio mun4838 = new Municipio(null, "São Miguel do Guamá", uf14);
		Municipio mun4885 = new Municipio(null, "São Sebastião da Boa Vista", uf14);
		Municipio mun4928 = new Municipio(null, "Sapucaia", uf14);
		Municipio mun4968 = new Municipio(null, "Senador José Porfírio", uf14);
		Municipio mun5087 = new Municipio(null, "Soure", uf14);
		Municipio mun5121 = new Municipio(null, "Tailândia", uf14);
		Municipio mun5209 = new Municipio(null, "Terra Alta", uf14);
		Municipio mun5218 = new Municipio(null, "Terra Santa", uf14);
		Municipio mun5253 = new Municipio(null, "Tomé-Açu", uf14);
		Municipio mun5263 = new Municipio(null, "Tracuateua", uf14);
		Municipio mun5266 = new Municipio(null, "Trairão", uf14);
		Municipio mun5304 = new Municipio(null, "Tucumã", uf14);
		Municipio mun5306 = new Municipio(null, "Tucuruí", uf14);
		Municipio mun5361 = new Municipio(null, "Ulianópolis", uf14);
		Municipio mun5391 = new Municipio(null, "Uruará", uf14);
		Municipio mun5497 = new Municipio(null, "Vigia", uf14);
		Municipio mun5521 = new Municipio(null, "Viseu", uf14);
		Municipio mun5534 = new Municipio(null, "Vitória do Xingu", uf14);
		Municipio mun5559 = new Municipio(null, "Xinguara", uf14);

		municipioRepository.saveAll(Arrays.asList(mun1000, mun1047, mun1076, mun1170, mun1260, mun1300, mun1333, mun1347, 
			mun1497, mun1507, mun1517, mun1519, mun1520, mun1595, mun1646, mun1742, 
			mun1805, mun1889, mun1926, mun2050, mun2147, mun2148, mun2208, mun2240, 
			mun214, mun219, mun221, mun425, mun433, mun441, mun454, mun458, 
			mun2278, mun2325, mun2447, mun2474, mun2486, mun2657, mun2777, mun2853, 
			mun2856, mun2912, mun2917, mun2926, mun2971, mun3038, mun3041, mun3103, 
			mun3114, mun3137, mun3200, mun3314, mun3333, mun3378, mun3414, mun3415, 
			mun3424, mun3427, mun3456, mun3470, mun3473, mun3493, mun3516, mun3566, 
			mun3603, mun3653, mun3725, mun3767, mun3867, mun3904, mun3938, mun3950, 
			mun3998, mun4035, mun4058, mun4111, mun4223, mun4268, mun4287, mun4313, 
			mun4331, mun4347, mun4371, mun4404, mun4417, mun4428, mun4434, mun4498, 
			mun4520, mun4521, mun4564, mun4600, mun4611, mun4613, mun4631, mun4648, 
			mun4661, mun4690, mun4699, mun4701, mun4838, mun4885, mun4928, mun4968, 
			mun484, mun500, mun583, mun596, mun600, mun685, mun715, mun743, 
			mun5087, mun5121, mun5209, mun5218, mun5253, mun5263, mun5266, mun5304, 
			mun5306, mun5361, mun5391, mun5497, mun5521, mun5534, mun5559, 
			mun6, mun12, mun20, mun41, mun46, mun108, mun122, mun136, 
			mun747, mun772, mun778, mun779, mun796, mun843, mun844, mun931));

	}
	
	private void instanciaMunUf15(UF uf15) {
		Municipio mun49 = new Municipio(null, "Água Branca", uf15);
		Municipio mun80 = new Municipio(null, "Aguiar", uf15);
		Municipio mun87 = new Municipio(null, "Alagoa Grande", uf15);
		Municipio mun88 = new Municipio(null, "Alagoa Nova", uf15);
		Municipio mun91 = new Municipio(null, "Alagoinha", uf15);
		Municipio mun98 = new Municipio(null, "Alcantil", uf15);
		Municipio mun116 = new Municipio(null, "Algodão de Jandaíra", uf15);
		Municipio mun117 = new Municipio(null, "Alhandra", uf15);
		Municipio mun208 = new Municipio(null, "Amparo", uf15);
		Municipio mun274 = new Municipio(null, "Aparecida", uf15);
		Municipio mun293 = new Municipio(null, "Araçagi", uf15);
		Municipio mun341 = new Municipio(null, "Arara", uf15);
		Municipio mun351 = new Municipio(null, "Araruna", uf15);
		Municipio mun370 = new Municipio(null, "Areia de Baraúnas", uf15);
		Municipio mun371 = new Municipio(null, "Areia", uf15);
		Municipio mun372 = new Municipio(null, "Areial", uf15);
		Municipio mun390 = new Municipio(null, "Aroeiras", uf15);
		Municipio mun414 = new Municipio(null, "Assunção", uf15);
		Municipio mun455 = new Municipio(null, "Baía da Traição", uf15);
		Municipio mun477 = new Municipio(null, "Bananeiras", uf15);
		Municipio mun494 = new Municipio(null, "Baraúna", uf15);
		Municipio mun509 = new Municipio(null, "Barra de Santa Rosa", uf15);
		Municipio mun510 = new Municipio(null, "Barra de Santana", uf15);
		Municipio mun513 = new Municipio(null, "Barra de São Miguel", uf15);
		Municipio mun566 = new Municipio(null, "Bayeux", uf15);
		Municipio mun581 = new Municipio(null, "Belém do Brejo do Cruz", uf15);
		Municipio mun584 = new Municipio(null, "Belém", uf15);
		Municipio mun609 = new Municipio(null, "Bernardino Batista", uf15);
		Municipio mun639 = new Municipio(null, "Boa Ventura", uf15);
		Municipio mun650 = new Municipio(null, "Boa Vista", uf15);
		Municipio mun688 = new Municipio(null, "Bom Jesus", uf15);
		Municipio mun703 = new Municipio(null, "Bom Sucesso", uf15);
		Municipio mun713 = new Municipio(null, "Bonito de Santa Fé", uf15);
		Municipio mun721 = new Municipio(null, "Boqueirão", uf15);
		Municipio mun727 = new Municipio(null, "Borborema", uf15);
		Municipio mun769 = new Municipio(null, "Brejo do Cruz", uf15);
		Municipio mun771 = new Municipio(null, "Brejo dos Santos", uf15);
		Municipio mun816 = new Municipio(null, "Caaporã", uf15);
		Municipio mun820 = new Municipio(null, "Cabaceiras", uf15);
		Municipio mun824 = new Municipio(null, "Cabedelo", uf15);
		Municipio mun846 = new Municipio(null, "Cachoeira dos Índios", uf15);
		Municipio mun857 = new Municipio(null, "Cacimba de Areia", uf15);
		Municipio mun858 = new Municipio(null, "Cacimba de Dentro", uf15);
		Municipio mun859 = new Municipio(null, "Cacimbas", uf15);
		Municipio mun884 = new Municipio(null, "Caiçara", uf15);
		Municipio mun895 = new Municipio(null, "Cajazeiras", uf15);
		Municipio mun896 = new Municipio(null, "Cajazeirinhas", uf15);
		Municipio mun904 = new Municipio(null, "Caldas Brandão", uf15);
		Municipio mun916 = new Municipio(null, "Camalaú", uf15);
		Municipio mun946 = new Municipio(null, "Campina Grande", uf15);
		Municipio mun964 = new Municipio(null, "Campo de Santana", uf15);
		Municipio mun1066 = new Municipio(null, "Capim", uf15);
		Municipio mun1101 = new Municipio(null, "Caraúbas", uf15);
		Municipio mun1149 = new Municipio(null, "Carrapateira", uf15);
		Municipio mun1166 = new Municipio(null, "Casserengue", uf15);
		Municipio mun1189 = new Municipio(null, "Catingueira", uf15);
		Municipio mun1191 = new Municipio(null, "Catolé do Rocha", uf15);
		Municipio mun1198 = new Municipio(null, "Caturité", uf15);
		Municipio mun1344 = new Municipio(null, "Conceição", uf15);
		Municipio mun1349 = new Municipio(null, "Condado", uf15);
		Municipio mun1351 = new Municipio(null, "Conde", uf15);
		Municipio mun1358 = new Municipio(null, "Congo", uf15);
		Municipio mun1387 = new Municipio(null, "Coremas", uf15);
		Municipio mun1443 = new Municipio(null, "Coxixola", uf15);
		Municipio mun1474 = new Municipio(null, "Cruz do Espírito Santo", uf15);
		Municipio mun1490 = new Municipio(null, "Cubati", uf15);
		Municipio mun1492 = new Municipio(null, "Cuité de Mamanguape", uf15);
		Municipio mun1493 = new Municipio(null, "Cuité", uf15);
		Municipio mun1494 = new Municipio(null, "Cuitegi", uf15);
		Municipio mun1513 = new Municipio(null, "Curral de Cima", uf15);
		Municipio mun1516 = new Municipio(null, "Curral Velho", uf15);
		Municipio mun1528 = new Municipio(null, "Damião", uf15);
		Municipio mun1550 = new Municipio(null, "Desterro", uf15);
		Municipio mun1556 = new Municipio(null, "Diamante", uf15);
		Municipio mun1611 = new Municipio(null, "Dona Inês", uf15);
		Municipio mun1634 = new Municipio(null, "Duas Estradas", uf15);
		Municipio mun1655 = new Municipio(null, "Emas", uf15);
		Municipio mun1697 = new Municipio(null, "Esperança", uf15);
		Municipio mun1737 = new Municipio(null, "Fagundes", uf15);
		Municipio mun1862 = new Municipio(null, "Frei Martinho", uf15);
		Municipio mun1875 = new Municipio(null, "Gado Bravo", uf15);
		Municipio mun2001 = new Municipio(null, "Guarabira", uf15);
		Municipio mun2048 = new Municipio(null, "Gurinhém", uf15);
		Municipio mun2049 = new Municipio(null, "Gurjão", uf15);
		Municipio mun2094 = new Municipio(null, "Ibiara", uf15);
		Municipio mun2142 = new Municipio(null, "Igaracy", uf15);
		Municipio mun2176 = new Municipio(null, "Imaculada", uf15);
		Municipio mun2203 = new Municipio(null, "Ingá", uf15);
		Municipio mun2284 = new Municipio(null, "Itabaiana", uf15);
		Municipio mun2393 = new Municipio(null, "Itaporanga", uf15);
		Municipio mun2395 = new Municipio(null, "Itapororoca", uf15);
		Municipio mun2420 = new Municipio(null, "Itatuba", uf15);
		Municipio mun2472 = new Municipio(null, "Jacaraú", uf15);
		Municipio mun2573 = new Municipio(null, "Jericó", uf15);
		Municipio mun2596 = new Municipio(null, "João Pessoa", uf15);
		Municipio mun2619 = new Municipio(null, "Juarez Távora", uf15);
		Municipio mun2622 = new Municipio(null, "Juazeirinho", uf15);
		Municipio mun2637 = new Municipio(null, "Junco do Seridó", uf15);
		Municipio mun2652 = new Municipio(null, "Juripiranga", uf15);
		Municipio mun2653 = new Municipio(null, "Juru", uf15);
		Municipio mun2686 = new Municipio(null, "Lagoa de Dentro", uf15);
		Municipio mun2711 = new Municipio(null, "Lagoa Seca", uf15);
		Municipio mun2713 = new Municipio(null, "Lagoa", uf15);
		Municipio mun2748 = new Municipio(null, "Lastro", uf15);
		Municipio mun2788 = new Municipio(null, "Livramento", uf15);
		Municipio mun2792 = new Municipio(null, "Logradouro", uf15);
		Municipio mun2802 = new Municipio(null, "Lucena", uf15);
		Municipio mun2852 = new Municipio(null, "Mãe d'Água", uf15);
		Municipio mun2875 = new Municipio(null, "Malta", uf15);
		Municipio mun2876 = new Municipio(null, "Mamanguape", uf15);
		Municipio mun2882 = new Municipio(null, "Manaíra", uf15);
		Municipio mun2935 = new Municipio(null, "Marcação", uf15);
		Municipio mun2948 = new Municipio(null, "Mari", uf15);
		Municipio mun2972 = new Municipio(null, "Marizópolis", uf15);
		Municipio mun2989 = new Municipio(null, "Massaranduba", uf15);
		Municipio mun2997 = new Municipio(null, "Mataraca", uf15);
		Municipio mun3008 = new Municipio(null, "Matinhas", uf15);
		Municipio mun3012 = new Municipio(null, "Mato Grosso", uf15);
		Municipio mun3024 = new Municipio(null, "Maturéia", uf15);
		Municipio mun3108 = new Municipio(null, "Mogeiro", uf15);
		Municipio mun3126 = new Municipio(null, "Montadas", uf15);
		Municipio mun3152 = new Municipio(null, "Monte Horebe", uf15);
		Municipio mun3160 = new Municipio(null, "Monteiro", uf15);
		Municipio mun3210 = new Municipio(null, "Mulungu", uf15);
		Municipio mun3244 = new Municipio(null, "Natuba", uf15);
		Municipio mun3253 = new Municipio(null, "Nazarezinho", uf15);
		Municipio mun3321 = new Municipio(null, "Nova Floresta", uf15);
		Municipio mun3352 = new Municipio(null, "Nova Olinda", uf15);
		Municipio mun3357 = new Municipio(null, "Nova Palmeira", uf15);
		Municipio mun3437 = new Municipio(null, "Olho d'Água", uf15);
		Municipio mun3445 = new Municipio(null, "Olivedos", uf15);
		Municipio mun3482 = new Municipio(null, "Ouro Velho", uf15);
		Municipio mun3599 = new Municipio(null, "Parari", uf15);
		Municipio mun3629 = new Municipio(null, "Passagem", uf15);
		Municipio mun3645 = new Municipio(null, "Patos", uf15);
		Municipio mun3663 = new Municipio(null, "Paulista", uf15);
		Municipio mun3686 = new Municipio(null, "Pedra Branca", uf15);
		Municipio mun3692 = new Municipio(null, "Pedra Lavrada", uf15);
		Municipio mun3701 = new Municipio(null, "Pedras de Fogo", uf15);
		Municipio mun3721 = new Municipio(null, "Pedro Régis", uf15);
		Municipio mun3763 = new Municipio(null, "Piancó", uf15);
		Municipio mun3770 = new Municipio(null, "Picuí", uf15);
		Municipio mun3780 = new Municipio(null, "Pilar", uf15);
		Municipio mun3782 = new Municipio(null, "Pilões", uf15);
		Municipio mun3784 = new Municipio(null, "Pilõezinhos", uf15);
		Municipio mun3858 = new Municipio(null, "Pirpirituba", uf15);
		Municipio mun3863 = new Municipio(null, "Pitimbu", uf15);
		Municipio mun3883 = new Municipio(null, "Pocinhos", uf15);
		Municipio mun3885 = new Municipio(null, "Poço Dantas", uf15);
		Municipio mun3888 = new Municipio(null, "Poço de José de Moura", uf15);
		Municipio mun3898 = new Municipio(null, "Pombal", uf15);
		Municipio mun4002 = new Municipio(null, "Prata", uf15);
		Municipio mun4039 = new Municipio(null, "Princesa Isabel", uf15);
		Municipio mun4051 = new Municipio(null, "Puxinanã", uf15);
		Municipio mun4066 = new Municipio(null, "Queimadas", uf15);
		Municipio mun4085 = new Municipio(null, "Quixabá", uf15);
		Municipio mun4121 = new Municipio(null, "Remígio", uf15);
		Municipio mun4135 = new Municipio(null, "Riachão do Bacamarte", uf15);
		Municipio mun4138 = new Municipio(null, "Riachão do Poço", uf15);
		Municipio mun4140 = new Municipio(null, "Riachão", uf15);
		Municipio mun4147 = new Municipio(null, "Riacho de Santo Antônio", uf15);
		Municipio mun4148 = new Municipio(null, "Riacho dos Cavalos", uf15);
		Municipio mun4240 = new Municipio(null, "Rio Tinto", uf15);
		Municipio mun4305 = new Municipio(null, "Salgadinho", uf15);
		Municipio mun4307 = new Municipio(null, "Salgado de São Félix", uf15);
		Municipio mun4357 = new Municipio(null, "Santa Cecília", uf15);
		Municipio mun4379 = new Municipio(null, "Santa Cruz", uf15);
		Municipio mun4396 = new Municipio(null, "Santa Helena", uf15);
		Municipio mun4400 = new Municipio(null, "Santa Inês", uf15);
		Municipio mun4421 = new Municipio(null, "Santa Luzia", uf15);
		Municipio mun4461 = new Municipio(null, "Santa Rita", uf15);
		Municipio mun4474 = new Municipio(null, "Santa Teresinha", uf15);
		Municipio mun4494 = new Municipio(null, "Santana de Mangueira", uf15);
		Municipio mun4515 = new Municipio(null, "Santana dos Garrotes", uf15);
		Municipio mun4522 = new Municipio(null, "Santarém", uf15);
		Municipio mun4531 = new Municipio(null, "Santo André", uf15);
		Municipio mun4582 = new Municipio(null, "São Bentinho", uf15);
		Municipio mun4591 = new Municipio(null, "São Bento", uf15);
		Municipio mun4610 = new Municipio(null, "São Domingos de Pombal", uf15);
		Municipio mun4614 = new Municipio(null, "São Domingos do Cariri", uf15);
		Municipio mun4652 = new Municipio(null, "São Francisco", uf15);
		Municipio mun4704 = new Municipio(null, "São João do Cariri", uf15);
		Municipio mun4719 = new Municipio(null, "São João do Rio do Peixe", uf15);
		Municipio mun4723 = new Municipio(null, "São João do Tigre", uf15);
		Municipio mun4742 = new Municipio(null, "São José da Lagoa Tapada", uf15);
		Municipio mun4751 = new Municipio(null, "São José de Caiana", uf15);
		Municipio mun4752 = new Municipio(null, "São José de Espinharas", uf15);
		Municipio mun4754 = new Municipio(null, "São José de Piranhas", uf15);
		Municipio mun4755 = new Municipio(null, "São José de Princesa", uf15);
		Municipio mun4761 = new Municipio(null, "São José do Bonfim", uf15);
		Municipio mun4762 = new Municipio(null, "São José do Brejo do Cruz", uf15);
		Municipio mun4785 = new Municipio(null, "São José do Sabugi", uf15);
		Municipio mun4793 = new Municipio(null, "São José dos Cordeiros", uf15);
		Municipio mun4796 = new Municipio(null, "São José dos Ramos", uf15);
		Municipio mun4817 = new Municipio(null, "São Mamede", uf15);
		Municipio mun4832 = new Municipio(null, "São Miguel de Taipu", uf15);
		Municipio mun4888 = new Municipio(null, "São Sebastião de Lagoa de Roça", uf15);
		Municipio mun4900 = new Municipio(null, "São Sebastião do Umbuzeiro", uf15);
		Municipio mun4922 = new Municipio(null, "Sapé", uf15);
		Municipio mun4984 = new Municipio(null, "Seridó", uf15);
		Municipio mun4992 = new Municipio(null, "Serra Branca", uf15);
		Municipio mun4993 = new Municipio(null, "Serra da Raiz", uf15);
		Municipio mun5002 = new Municipio(null, "Serra Grande", uf15);
		Municipio mun5007 = new Municipio(null, "Serra Redonda", uf15);
		Municipio mun5017 = new Municipio(null, "Serraria", uf15);
		Municipio mun5029 = new Municipio(null, "Sertãozinho", uf15);
		Municipio mun5070 = new Municipio(null, "Sobrado", uf15);
		Municipio mun5075 = new Municipio(null, "Solânea", uf15);
		Municipio mun5077 = new Municipio(null, "Soledade", uf15);
		Municipio mun5086 = new Municipio(null, "Sossêgo", uf15);
		Municipio mun5088 = new Municipio(null, "Sousa", uf15);
		Municipio mun5097 = new Municipio(null, "Sumé", uf15);
		Municipio mun5149 = new Municipio(null, "Taperoá", uf15);
		Municipio mun5181 = new Municipio(null, "Tavares", uf15);
		Municipio mun5186 = new Municipio(null, "Teixeira", uf15);
		Municipio mun5196 = new Municipio(null, "Tenório", uf15);
		Municipio mun5296 = new Municipio(null, "Triunfo", uf15);
		Municipio mun5360 = new Municipio(null, "Uiraúna", uf15);
		Municipio mun5367 = new Municipio(null, "Umbuzeiro", uf15);
		Municipio mun5449 = new Municipio(null, "Várzea", uf15);
		Municipio mun5496 = new Municipio(null, "Vieirópolis", uf15);
		Municipio mun5526 = new Municipio(null, "Vista Serrana", uf15);
		Municipio mun5561 = new Municipio(null, "Zabelê", uf15);

		municipioRepository.saveAll(Arrays.asList(mun1191, mun1198, mun1344, mun1349, mun1351, mun1358, mun1387, mun1443, 
			mun1474, mun1490, mun1492, mun1493, mun1494, mun1513, mun1516, mun1528, 
			mun1550, mun1556, mun1611, mun1634, mun1655, mun1697, mun1737, mun1862, 
			mun1875, mun2001, mun2048, mun2049, mun2094, mun2142, mun2176, mun2203, 
			mun208, mun274, mun293, mun341, mun351, mun370, mun371, mun372, 
			mun2284, mun2393, mun2395, mun2420, mun2472, mun2573, mun2596, mun2619, 
			mun2622, mun2637, mun2652, mun2653, mun2686, mun2711, mun2713, mun2748, 
			mun2788, mun2792, mun2802, mun2852, mun2875, mun2876, mun2882, mun2935, 
			mun2948, mun2972, mun2989, mun2997, mun3008, mun3012, mun3024, mun3108, 
			mun3126, mun3152, mun3160, mun3210, mun3244, mun3253, mun3321, mun3352, 
			mun3357, mun3437, mun3445, mun3482, mun3599, mun3629, mun3645, mun3663, 
			mun3686, mun3692, mun3701, mun3721, mun3763, mun3770, mun3780, mun3782, 
			mun3784, mun3858, mun3863, mun3883, mun3885, mun3888, mun3898, mun4002, 
			mun390, mun414, mun455, mun477, mun494, mun509, mun510, mun513, 
			mun4039, mun4051, mun4066, mun4085, mun4121, mun4135, mun4138, mun4140, 
			mun4147, mun4148, mun4240, mun4305, mun4307, mun4357, mun4379, mun4396, 
			mun4400, mun4421, mun4461, mun4474, mun4494, mun4515, mun4522, mun4531, 
			mun4582, mun4591, mun4610, mun4614, mun4652, mun4704, mun4719, mun4723, 
			mun4742, mun4751, mun4752, mun4754, mun4755, mun4761, mun4762, mun4785, 
			mun4793, mun4796, mun4817, mun4832, mun4888, mun4900, mun4922, mun4984, 
			mun49, mun80, mun87, mun88, mun91, mun98, mun116, mun117, 
			mun4992, mun4993, mun5002, mun5007, mun5017, mun5029, mun5070, mun5075, 
			mun5077, mun5086, mun5088, mun5097, mun5149, mun5181, mun5186, mun5196, 
			mun5296, mun5360, mun5367, mun5449, mun5496, mun5526, mun5561, 
			mun566, mun581, mun584, mun609, mun639, mun650, mun688, mun703, 
			mun713, mun721, mun727, mun769, mun771, mun816, mun820, mun824, 
			mun846, mun857, mun858, mun859, mun884, mun895, mun896, mun904, 
			mun916, mun946, mun964, mun1066, mun1101, mun1149, mun1166, mun1189));

	}
	
	private void instanciaMunUf16(UF uf16) {
		Municipio mun15 = new Municipio(null, "Abreu e Lima", uf16);
		Municipio mun37 = new Municipio(null, "Afogados da Ingazeira", uf16);
		Municipio mun40 = new Municipio(null, "Afrânio", uf16);
		Municipio mun42 = new Municipio(null, "Agrestina", uf16);
		Municipio mun61 = new Municipio(null, "Água Preta", uf16);
		Municipio mun65 = new Municipio(null, "Águas Belas", uf16);
		Municipio mun92 = new Municipio(null, "Alagoinha", uf16);
		Municipio mun119 = new Municipio(null, "Aliança", uf16);
		Municipio mun139 = new Municipio(null, "Altinho", uf16);
		Municipio mun190 = new Municipio(null, "Amaraji", uf16);
		Municipio mun237 = new Municipio(null, "Angelim", uf16);
		Municipio mun304 = new Municipio(null, "Araçoiaba", uf16);
		Municipio mun349 = new Municipio(null, "Araripina", uf16);
		Municipio mun364 = new Municipio(null, "Arcoverde", uf16);
		Municipio mun508 = new Municipio(null, "Barra de Guabiraba", uf16);
		Municipio mun544 = new Municipio(null, "Barreiros", uf16);
		Municipio mun579 = new Municipio(null, "Belém de Maria", uf16);
		Municipio mun580 = new Municipio(null, "Belém de São Francisco", uf16);
		Municipio mun592 = new Municipio(null, "Belo Jardim", uf16);
		Municipio mun618 = new Municipio(null, "Betânia", uf16);
		Municipio mun620 = new Municipio(null, "Bezerros", uf16);
		Municipio mun661 = new Municipio(null, "Bodocó", uf16);
		Municipio mun665 = new Municipio(null, "Bom Conselho", uf16);
		Municipio mun671 = new Municipio(null, "Bom Jardim", uf16);
		Municipio mun716 = new Municipio(null, "Bonito", uf16);
		Municipio mun761 = new Municipio(null, "Brejão", uf16);
		Municipio mun764 = new Municipio(null, "Brejinho", uf16);
		Municipio mun767 = new Municipio(null, "Brejo da Madre de Deus", uf16);
		Municipio mun791 = new Municipio(null, "Buenos Aires", uf16);
		Municipio mun794 = new Municipio(null, "Buíque", uf16);
		Municipio mun826 = new Municipio(null, "Cabo de Santo Agostinho", uf16);
		Municipio mun831 = new Municipio(null, "Cabrobó", uf16);
		Municipio mun853 = new Municipio(null, "Cachoeirinha", uf16);
		Municipio mun870 = new Municipio(null, "Caetés", uf16);
		Municipio mun902 = new Municipio(null, "Calçado", uf16);
		Municipio mun912 = new Municipio(null, "Calumbi", uf16);
		Municipio mun921 = new Municipio(null, "Camaragibe", uf16);
		Municipio mun932 = new Municipio(null, "Camocim de São Félix", uf16);
		Municipio mun998 = new Municipio(null, "Camutanga", uf16);
		Municipio mun1031 = new Municipio(null, "Canhotinho", uf16);
		Municipio mun1083 = new Municipio(null, "Capoeiras", uf16);
		Municipio mun1138 = new Municipio(null, "Carnaíba", uf16);
		Municipio mun1142 = new Municipio(null, "Carnaubeira da Penha", uf16);
		Municipio mun1147 = new Municipio(null, "Carpina", uf16);
		Municipio mun1151 = new Municipio(null, "Caruaru", uf16);
		Municipio mun1165 = new Municipio(null, "Casinhas", uf16);
		Municipio mun1187 = new Municipio(null, "Catende", uf16);
		Municipio mun1212 = new Municipio(null, "Cedro", uf16);
		Municipio mun1239 = new Municipio(null, "Chã de Alegria", uf16);
		Municipio mun1240 = new Municipio(null, "Chã Grande", uf16);
		Municipio mun1350 = new Municipio(null, "Condado", uf16);
		Municipio mun1420 = new Municipio(null, "Correntes", uf16);
		Municipio mun1422 = new Municipio(null, "Cortês", uf16);
		Municipio mun1498 = new Municipio(null, "Cumaru", uf16);
		Municipio mun1504 = new Municipio(null, "Cupira", uf16);
		Municipio mun1525 = new Municipio(null, "Custódia", uf16);
		Municipio mun1618 = new Municipio(null, "Dormentes", uf16);
		Municipio mun1691 = new Municipio(null, "Escada", uf16);
		Municipio mun1735 = new Municipio(null, "Exu", uf16);
		Municipio mun1762 = new Municipio(null, "Feira Nova", uf16);
		Municipio mun1774 = new Municipio(null, "Fernando de Noronha", uf16);
		Municipio mun1782 = new Municipio(null, "Ferreiros", uf16);
		Municipio mun1803 = new Municipio(null, "Flores", uf16);
		Municipio mun1807 = new Municipio(null, "Floresta", uf16);
		Municipio mun1863 = new Municipio(null, "Frei Miguelinho", uf16);
		Municipio mun1881 = new Municipio(null, "Gameleira", uf16);
		Municipio mun1884 = new Municipio(null, "Garanhuns", uf16);
		Municipio mun1916 = new Municipio(null, "Glória do Goitá", uf16);
		Municipio mun1923 = new Municipio(null, "Goiana", uf16);
		Municipio mun1963 = new Municipio(null, "Granito", uf16);
		Municipio mun1968 = new Municipio(null, "Gravatá", uf16);
		Municipio mun2080 = new Municipio(null, "Iati", uf16);
		Municipio mun2101 = new Municipio(null, "Ibimirim", uf16);
		Municipio mun2111 = new Municipio(null, "Ibirajuba", uf16);
		Municipio mun2149 = new Municipio(null, "Igarassu", uf16);
		Municipio mun2158 = new Municipio(null, "Iguaraci", uf16);
		Municipio mun2168 = new Municipio(null, "Ilha de Itamaracá", uf16);
		Municipio mun2188 = new Municipio(null, "Inajá", uf16);
		Municipio mun2205 = new Municipio(null, "Ingazeira", uf16);
		Municipio mun2242 = new Municipio(null, "Ipojuca", uf16);
		Municipio mun2250 = new Municipio(null, "Ipubi", uf16);
		Municipio mun2302 = new Municipio(null, "Itacuruba", uf16);
		Municipio mun2317 = new Municipio(null, "Itaíba", uf16);
		Municipio mun2343 = new Municipio(null, "Itambé", uf16);
		Municipio mun2371 = new Municipio(null, "Itapetim", uf16);
		Municipio mun2385 = new Municipio(null, "Itapissuma", uf16);
		Municipio mun2405 = new Municipio(null, "Itaquitinga", uf16);
		Municipio mun2462 = new Municipio(null, "Jaboatão dos Guararapes", uf16);
		Municipio mun2532 = new Municipio(null, "Jaqueira", uf16);
		Municipio mun2553 = new Municipio(null, "Jataúba", uf16);
		Municipio mun2558 = new Municipio(null, "Jatobá", uf16);
		Municipio mun2588 = new Municipio(null, "João Alfredo", uf16);
		Municipio mun2601 = new Municipio(null, "Joaquim Nabuco", uf16);
		Municipio mun2627 = new Municipio(null, "Jucati", uf16);
		Municipio mun2644 = new Municipio(null, "Jupi", uf16);
		Municipio mun2650 = new Municipio(null, "Jurema", uf16);
		Municipio mun2691 = new Municipio(null, "Lagoa do Carro", uf16);
		Municipio mun2692 = new Municipio(null, "Lagoa do Itaenga", uf16);
		Municipio mun2694 = new Municipio(null, "Lagoa do Ouro", uf16);
		Municipio mun2698 = new Municipio(null, "Lagoa dos Gatos", uf16);
		Municipio mun2705 = new Municipio(null, "Lagoa Grande", uf16);
		Municipio mun2729 = new Municipio(null, "Lajedo", uf16);
		Municipio mun2779 = new Municipio(null, "Limoeiro", uf16);
		Municipio mun2832 = new Municipio(null, "Macaparana", uf16);
		Municipio mun2844 = new Municipio(null, "Machados", uf16);
		Municipio mun2884 = new Municipio(null, "Manari", uf16);
		Municipio mun2922 = new Municipio(null, "Maraial", uf16);
		Municipio mun3087 = new Municipio(null, "Mirandiba", uf16);
		Municipio mun3172 = new Municipio(null, "Moreilândia", uf16);
		Municipio mun3174 = new Municipio(null, "Moreno", uf16);
		Municipio mun3247 = new Municipio(null, "Nazaré da Mata", uf16);
		Municipio mun3443 = new Municipio(null, "Olinda", uf16);
		Municipio mun3461 = new Municipio(null, "Orobó", uf16);
		Municipio mun3462 = new Municipio(null, "Orocó", uf16);
		Municipio mun3472 = new Municipio(null, "Ouricuri", uf16);
		Municipio mun3526 = new Municipio(null, "Palmares", uf16);
		Municipio mun3542 = new Municipio(null, "Palmeirina", uf16);
		Municipio mun3555 = new Municipio(null, "Panelas", uf16);
		Municipio mun3593 = new Municipio(null, "Paranatama", uf16);
		Municipio mun3618 = new Municipio(null, "Parnamirim", uf16);
		Municipio mun3632 = new Municipio(null, "Passira", uf16);
		Municipio mun3656 = new Municipio(null, "Paudalho", uf16);
		Municipio mun3664 = new Municipio(null, "Paulista", uf16);
		Municipio mun3696 = new Municipio(null, "Pedra", uf16);
		Municipio mun3755 = new Municipio(null, "Pesqueira", uf16);
		Municipio mun3756 = new Municipio(null, "Petrolândia", uf16);
		Municipio mun3759 = new Municipio(null, "Petrolina", uf16);
		Municipio mun3882 = new Municipio(null, "Poção", uf16);
		Municipio mun3899 = new Municipio(null, "Pombos", uf16);
		Municipio mun4036 = new Municipio(null, "Primavera", uf16);
		Municipio mun4080 = new Municipio(null, "Quipapá", uf16);
		Municipio mun4086 = new Municipio(null, "Quixaba", uf16);
		Municipio mun4106 = new Municipio(null, "Recife", uf16);
		Municipio mun4144 = new Municipio(null, "Riacho das Almas", uf16);
		Municipio mun4175 = new Municipio(null, "Ribeirão", uf16);
		Municipio mun4216 = new Municipio(null, "Rio Formoso", uf16);
		Municipio mun4299 = new Municipio(null, "Sairé", uf16);
		Municipio mun4306 = new Municipio(null, "Salgadinho", uf16);
		Municipio mun4310 = new Municipio(null, "Salgueiro", uf16);
		Municipio mun4316 = new Municipio(null, "Saloá", uf16);
		Municipio mun4339 = new Municipio(null, "Sanharó", uf16);
		Municipio mun4362 = new Municipio(null, "Santa Cruz da Baixa Verde", uf16);
		Municipio mun4372 = new Municipio(null, "Santa Cruz do Capibaribe", uf16);
		Municipio mun4380 = new Municipio(null, "Santa Cruz", uf16);
		Municipio mun4390 = new Municipio(null, "Santa Filomena", uf16);
		Municipio mun4425 = new Municipio(null, "Santa Maria da Boa Vista", uf16);
		Municipio mun4431 = new Municipio(null, "Santa Maria do Cambucá", uf16);
		Municipio mun4485 = new Municipio(null, "Santa Terezinha", uf16);
		Municipio mun4580 = new Municipio(null, "São Benedito do Sul", uf16);
		Municipio mun4589 = new Municipio(null, "São Bento do Una", uf16);
		Municipio mun4602 = new Municipio(null, "São Caitano", uf16);
		Municipio mun4728 = new Municipio(null, "São João", uf16);
		Municipio mun4732 = new Municipio(null, "São Joaquim do Monte", uf16);
		Municipio mun4741 = new Municipio(null, "São José da Coroa Grande", uf16);
		Municipio mun4760 = new Municipio(null, "São José do Belmonte", uf16);
		Municipio mun4769 = new Municipio(null, "São José do Egito", uf16);
		Municipio mun4800 = new Municipio(null, "São Lourenço da Mata", uf16);
		Municipio mun4919 = new Municipio(null, "São Vicente Ferrer", uf16);
		Municipio mun5008 = new Municipio(null, "Serra Talhada", uf16);
		Municipio mun5021 = new Municipio(null, "Serrita", uf16);
		Municipio mun5025 = new Municipio(null, "Sertânia", uf16);
		Municipio mun5060 = new Municipio(null, "Sirinhaém", uf16);
		Municipio mun5079 = new Municipio(null, "Solidão", uf16);
		Municipio mun5099 = new Municipio(null, "Surubim", uf16);
		Municipio mun5108 = new Municipio(null, "Tabira", uf16);
		Municipio mun5114 = new Municipio(null, "Tacaimbó", uf16);
		Municipio mun5115 = new Municipio(null, "Tacaratu", uf16);
		Municipio mun5128 = new Municipio(null, "Tamandaré", uf16);
		Municipio mun5165 = new Municipio(null, "Taquaritinga do Norte", uf16);
		Municipio mun5207 = new Municipio(null, "Terezinha", uf16);
		Municipio mun5213 = new Municipio(null, "Terra Nova", uf16);
		Municipio mun5231 = new Municipio(null, "Timbaúba", uf16);
		Municipio mun5255 = new Municipio(null, "Toritama", uf16);
		Municipio mun5264 = new Municipio(null, "Tracunhaém", uf16);
		Municipio mun5293 = new Municipio(null, "Trindade", uf16);
		Municipio mun5297 = new Municipio(null, "Triunfo", uf16);
		Municipio mun5317 = new Municipio(null, "Tupanatinga", uf16);
		Municipio mun5322 = new Municipio(null, "Tuparetama", uf16);
		Municipio mun5459 = new Municipio(null, "Venturosa", uf16);
		Municipio mun5468 = new Municipio(null, "Verdejante", uf16);
		Municipio mun5475 = new Municipio(null, "Vertente do Lério", uf16);
		Municipio mun5476 = new Municipio(null, "Vertentes", uf16);
		Municipio mun5484 = new Municipio(null, "Vicência", uf16);
		Municipio mun5531 = new Municipio(null, "Vitória de Santo Antão", uf16);
		Municipio mun5558 = new Municipio(null, "Xexéu", uf16);

		municipioRepository.saveAll(Arrays.asList(mun1083, mun1138, mun1142, mun1147, mun1151, mun1165, mun1187, mun1212, 
			mun1239, mun1240, mun1350, mun1420, mun1422, mun1498, mun1504, mun1525, 
			mun139, mun190, mun237, mun304, mun349, mun364, mun508, mun544, 
			mun15, mun37, mun40, mun42, mun61, mun65, mun92, mun119, 
			mun1618, mun1691, mun1735, mun1762, mun1774, mun1782, mun1803, mun1807, 
			mun1863, mun1881, mun1884, mun1916, mun1923, mun1963, mun1968, mun2080, 
			mun2101, mun2111, mun2149, mun2158, mun2168, mun2188, mun2205, mun2242, 
			mun2250, mun2302, mun2317, mun2343, mun2371, mun2385, mun2405, mun2462, 
			mun2532, mun2553, mun2558, mun2588, mun2601, mun2627, mun2644, mun2650, 
			mun2691, mun2692, mun2694, mun2698, mun2705, mun2729, mun2779, mun2832, 
			mun2844, mun2884, mun2922, mun3087, mun3172, mun3174, mun3247, mun3443, 
			mun3461, mun3462, mun3472, mun3526, mun3542, mun3555, mun3593, mun3618, 
			mun3632, mun3656, mun3664, mun3696, mun3755, mun3756, mun3759, mun3882, 
			mun3899, mun4036, mun4080, mun4086, mun4106, mun4144, mun4175, mun4216, 
			mun4299, mun4306, mun4310, mun4316, mun4339, mun4362, mun4372, mun4380, 
			mun4390, mun4425, mun4431, mun4485, mun4580, mun4589, mun4602, mun4728, 
			mun4732, mun4741, mun4760, mun4769, mun4800, mun4919, mun5008, mun5021, 
			mun5025, mun5060, mun5079, mun5099, mun5108, mun5114, mun5115, mun5128, 
			mun5165, mun5207, mun5213, mun5231, mun5255, mun5264, mun5293, mun5297, 
			mun5317, mun5322, mun5459, mun5468, mun5475, mun5476, mun5484, mun5531, 
			mun5558, 
			mun579, mun580, mun592, mun618, mun620, mun661, mun665, mun671, 
			mun716, mun761, mun764, mun767, mun791, mun794, mun826, mun831, 
			mun853, mun870, mun902, mun912, mun921, mun932, mun998, mun1031));

	}
	
	private void instanciaMunUf17(UF uf17) {
		Municipio mun24 = new Municipio(null, "Acauã", uf17);
		Municipio mun43 = new Municipio(null, "Agricolândia", uf17);
		Municipio mun50 = new Municipio(null, "Água Branca", uf17);
		Municipio mun90 = new Municipio(null, "Alagoinha do Piauí", uf17);
		Municipio mun104 = new Municipio(null, "Alegrete do Piauí", uf17);
		Municipio mun156 = new Municipio(null, "Alto Longá", uf17);
		Municipio mun169 = new Municipio(null, "Altos", uf17);
		Municipio mun180 = new Municipio(null, "Alvorada do Gurguéia", uf17);
		Municipio mun194 = new Municipio(null, "Amarante", uf17);
		Municipio mun239 = new Municipio(null, "Angical do Piauí", uf17);
		Municipio mun250 = new Municipio(null, "Anísio de Abreu", uf17);
		Municipio mun258 = new Municipio(null, "Antônio Almeida", uf17);
		Municipio mun388 = new Municipio(null, "Aroazes", uf17);
		Municipio mun389 = new Municipio(null, "Aroeiras do Itaim", uf17);
		Municipio mun392 = new Municipio(null, "Arraial", uf17);
		Municipio mun413 = new Municipio(null, "Assunção do Piauí", uf17);
		Municipio mun442 = new Municipio(null, "Avelino Lopes", uf17);
		Municipio mun459 = new Municipio(null, "Baixa Grande do Ribeiro", uf17);
		Municipio mun506 = new Municipio(null, "Barra d'Alcântara", uf17);
		Municipio mun538 = new Municipio(null, "Barras", uf17);
		Municipio mun540 = new Municipio(null, "Barreiras do Piauí", uf17);
		Municipio mun549 = new Municipio(null, "Barro Duro", uf17);
		Municipio mun561 = new Municipio(null, "Batalha", uf17);
		Municipio mun575 = new Municipio(null, "Bela Vista do Piauí", uf17);
		Municipio mun582 = new Municipio(null, "Belém do Piauí", uf17);
		Municipio mun597 = new Municipio(null, "Beneditinos", uf17);
		Municipio mun614 = new Municipio(null, "Bertolínia", uf17);
		Municipio mun617 = new Municipio(null, "Betânia do Piauí", uf17);
		Municipio mun636 = new Municipio(null, "Boa Hora", uf17);
		Municipio mun656 = new Municipio(null, "Bocaina", uf17);
		Municipio mun689 = new Municipio(null, "Bom Jesus", uf17);
		Municipio mun694 = new Municipio(null, "Bom Princípio do Piauí", uf17);
		Municipio mun706 = new Municipio(null, "Bonfim do Piauí", uf17);
		Municipio mun720 = new Municipio(null, "Boqueirão do Piauí", uf17);
		Municipio mun753 = new Municipio(null, "Brasileira", uf17);
		Municipio mun770 = new Municipio(null, "Brejo do Piauí", uf17);
		Municipio mun803 = new Municipio(null, "Buriti dos Lopes", uf17);
		Municipio mun804 = new Municipio(null, "Buriti dos Montes", uf17);
		Municipio mun822 = new Municipio(null, "Cabeceiras do Piauí", uf17);
		Municipio mun894 = new Municipio(null, "Cajazeiras do Piauí", uf17);
		Municipio mun898 = new Municipio(null, "Cajueiro da Praia", uf17);
		Municipio mun908 = new Municipio(null, "Caldeirão Grande do Piauí", uf17);
		Municipio mun950 = new Municipio(null, "Campinas do Piauí", uf17);
		Municipio mun956 = new Municipio(null, "Campo Alegre do Fidalgo", uf17);
		Municipio mun971 = new Municipio(null, "Campo Grande do Piauí", uf17);
		Municipio mun974 = new Municipio(null, "Campo Largo do Piauí", uf17);
		Municipio mun979 = new Municipio(null, "Campo Maior", uf17);
		Municipio mun1010 = new Municipio(null, "Canavieira", uf17);
		Municipio mun1043 = new Municipio(null, "Canto do Buriti", uf17);
		Municipio mun1072 = new Municipio(null, "Capitão de Campos", uf17);
		Municipio mun1074 = new Municipio(null, "Capitão Gervásio Oliveira", uf17);
		Municipio mun1088 = new Municipio(null, "Caracol", uf17);
		Municipio mun1100 = new Municipio(null, "Caraúbas do Piauí", uf17);
		Municipio mun1113 = new Municipio(null, "Caridade do Piauí", uf17);
		Municipio mun1174 = new Municipio(null, "Castelo do Piauí", uf17);
		Municipio mun1206 = new Municipio(null, "Caxingó", uf17);
		Municipio mun1287 = new Municipio(null, "Cocal de Telha", uf17);
		Municipio mun1289 = new Municipio(null, "Cocal dos Alves", uf17);
		Municipio mun1290 = new Municipio(null, "Cocal", uf17);
		Municipio mun1299 = new Municipio(null, "Coivaras", uf17);
		Municipio mun1312 = new Municipio(null, "Colônia do Gurguéia", uf17);
		Municipio mun1313 = new Municipio(null, "Colônia do Piauí", uf17);
		Municipio mun1334 = new Municipio(null, "Conceição do Canindé", uf17);
		Municipio mun1404 = new Municipio(null, "Coronel José Dias", uf17);
		Municipio mun1419 = new Municipio(null, "Corrente", uf17);
		Municipio mun1457 = new Municipio(null, "Cristalândia do Piauí", uf17);
		Municipio mun1465 = new Municipio(null, "Cristino Castro", uf17);
		Municipio mun1506 = new Municipio(null, "Curimatá", uf17);
		Municipio mun1512 = new Municipio(null, "Currais", uf17);
		Municipio mun1515 = new Municipio(null, "Curral Novo do Piauí", uf17);
		Municipio mun1518 = new Municipio(null, "Curralinhos", uf17);
		Municipio mun1540 = new Municipio(null, "Demerval Lobão", uf17);
		Municipio mun1567 = new Municipio(null, "Dirceu Arcoverde", uf17);
		Municipio mun1596 = new Municipio(null, "Dom Expedito Lopes", uf17);
		Municipio mun1598 = new Municipio(null, "Dom Inocêncio", uf17);
		Municipio mun1607 = new Municipio(null, "Domingos Mourão", uf17);
		Municipio mun1649 = new Municipio(null, "Elesbão Veloso", uf17);
		Municipio mun1651 = new Municipio(null, "Eliseu Martins", uf17);
		Municipio mun1698 = new Municipio(null, "Esperantina", uf17);
		Municipio mun1745 = new Municipio(null, "Fartura do Piauí", uf17);
		Municipio mun1802 = new Municipio(null, "Flores do Piauí", uf17);
		Municipio mun1806 = new Municipio(null, "Floresta do Piauí", uf17);
		Municipio mun1812 = new Municipio(null, "Floriano", uf17);
		Municipio mun1844 = new Municipio(null, "Francinópolis", uf17);
		Municipio mun1846 = new Municipio(null, "Francisco Ayres", uf17);
		Municipio mun1851 = new Municipio(null, "Francisco Macedo", uf17);
		Municipio mun1854 = new Municipio(null, "Francisco Santos", uf17);
		Municipio mun1868 = new Municipio(null, "Fronteiras", uf17);
		Municipio mun1898 = new Municipio(null, "Geminiano", uf17);
		Municipio mun1909 = new Municipio(null, "Gilbués", uf17);
		Municipio mun1977 = new Municipio(null, "Guadalupe", uf17);
		Municipio mun2033 = new Municipio(null, "Guaribas", uf17);
		Municipio mun2069 = new Municipio(null, "Hugo Napoleão", uf17);
		Municipio mun2169 = new Municipio(null, "Ilha Grande", uf17);
		Municipio mun2212 = new Municipio(null, "Inhuma", uf17);
		Municipio mun2237 = new Municipio(null, "Ipiranga do Piauí", uf17);
		Municipio mun2280 = new Municipio(null, "Isaías Coelho", uf17);
		Municipio mun2319 = new Municipio(null, "Itainópolis", uf17);
		Municipio mun2426 = new Municipio(null, "Itaueira", uf17);
		Municipio mun2481 = new Municipio(null, "Jacobina do Piauí", uf17);
		Municipio mun2506 = new Municipio(null, "Jaicós", uf17);
		Municipio mun2541 = new Municipio(null, "Jardim do Mulato", uf17);
		Municipio mun2556 = new Municipio(null, "Jatobá do Piauí", uf17);
		Municipio mun2576 = new Municipio(null, "Jerumenha", uf17);
		Municipio mun2590 = new Municipio(null, "João Costa", uf17);
		Municipio mun2602 = new Municipio(null, "Joaquim Pires", uf17);
		Municipio mun2604 = new Municipio(null, "Joca Marques", uf17);
		Municipio mun2612 = new Municipio(null, "José de Freitas", uf17);
		Municipio mun2624 = new Municipio(null, "Juazeiro do Piauí", uf17);
		Municipio mun2632 = new Municipio(null, "Júlio Borges", uf17);
		Municipio mun2651 = new Municipio(null, "Jurema", uf17);
		Municipio mun2680 = new Municipio(null, "Lagoa Alegre", uf17);
		Municipio mun2688 = new Municipio(null, "Lagoa de São Francisco", uf17);
		Municipio mun2690 = new Municipio(null, "Lagoa do Barro do Piauí", uf17);
		Municipio mun2695 = new Municipio(null, "Lagoa do Piauí", uf17);
		Municipio mun2696 = new Municipio(null, "Lagoa do Sítio", uf17);
		Municipio mun2715 = new Municipio(null, "Lagoinha do Piauí", uf17);
		Municipio mun2737 = new Municipio(null, "Landri Sales", uf17);
		Municipio mun2807 = new Municipio(null, "Luís Correia", uf17);
		Municipio mun2824 = new Municipio(null, "Luzilândia", uf17);
		Municipio mun2849 = new Municipio(null, "Madeiro", uf17);
		Municipio mun2898 = new Municipio(null, "Manoel Emídio", uf17);
		Municipio mun2941 = new Municipio(null, "Marcolândia", uf17);
		Municipio mun2942 = new Municipio(null, "Marcos Parente", uf17);
		Municipio mun2987 = new Municipio(null, "Massapê do Piauí", uf17);
		Municipio mun3005 = new Municipio(null, "Matias Olímpio", uf17);
		Municipio mun3054 = new Municipio(null, "Miguel Alves", uf17);
		Municipio mun3056 = new Municipio(null, "Miguel Leão", uf17);
		Municipio mun3063 = new Municipio(null, "Milton Brandão", uf17);
		Municipio mun3122 = new Municipio(null, "Monsenhor Gil", uf17);
		Municipio mun3123 = new Municipio(null, "Monsenhor Hipólito", uf17);
		Municipio mun3134 = new Municipio(null, "Monte Alegre do Piauí", uf17);
		Municipio mun3183 = new Municipio(null, "Morro Cabeça no Tempo", uf17);
		Municipio mun3186 = new Municipio(null, "Morro do Chapéu do Piauí", uf17);
		Municipio mun3223 = new Municipio(null, "Murici dos Portelas", uf17);
		Municipio mun3248 = new Municipio(null, "Nazaré do Piauí", uf17);
		Municipio mun3281 = new Municipio(null, "Nossa Senhora de Nazaré", uf17);
		Municipio mun3284 = new Municipio(null, "Nossa Senhora dos Remédios", uf17);
		Municipio mun3372 = new Municipio(null, "Nova Santa Rita", uf17);
		Municipio mun3411 = new Municipio(null, "Novo Oriente do Piauí", uf17);
		Municipio mun3417 = new Municipio(null, "Novo Santo Antônio", uf17);
		Municipio mun3428 = new Municipio(null, "Oeiras", uf17);
		Municipio mun3435 = new Municipio(null, "Olho d'Água do Piauí", uf17);
		Municipio mun3503 = new Municipio(null, "Padre Marcos", uf17);
		Municipio mun3505 = new Municipio(null, "Paes Landim", uf17);
		Municipio mun3514 = new Municipio(null, "Pajeú do Piauí", uf17);
		Municipio mun3532 = new Municipio(null, "Palmeira do Piauí", uf17);
		Municipio mun3536 = new Municipio(null, "Palmeirais", uf17);
		Municipio mun3561 = new Municipio(null, "Paquetá", uf17);
		Municipio mun3616 = new Municipio(null, "Parnaguá", uf17);
		Municipio mun3617 = new Municipio(null, "Parnaíba", uf17);
		Municipio mun3627 = new Municipio(null, "Passagem Franca do Piauí", uf17);
		Municipio mun3644 = new Municipio(null, "Patos do Piauí", uf17);
		Municipio mun3652 = new Municipio(null, "Pau d'Arco do Piauí", uf17);
		Municipio mun3665 = new Municipio(null, "Paulistana", uf17);
		Municipio mun3677 = new Municipio(null, "Pavussu", uf17);
		Municipio mun3717 = new Municipio(null, "Pedro II", uf17);
		Municipio mun3718 = new Municipio(null, "Pedro Laurentino", uf17);
		Municipio mun3769 = new Municipio(null, "Picos", uf17);
		Municipio mun3788 = new Municipio(null, "Pimenteiras", uf17);
		Municipio mun3816 = new Municipio(null, "Pio IX", uf17);
		Municipio mun3825 = new Municipio(null, "Piracuruca", uf17);
		Municipio mun3856 = new Municipio(null, "Piripiri", uf17);
		Municipio mun3942 = new Municipio(null, "Porto Alegre do Piauí", uf17);
		Municipio mun3976 = new Municipio(null, "Porto", uf17);
		Municipio mun4000 = new Municipio(null, "Prata do Piauí", uf17);
		Municipio mun4065 = new Municipio(null, "Queimada Nova", uf17);
		Municipio mun4110 = new Municipio(null, "Redenção do Gurguéia", uf17);
		Municipio mun4115 = new Municipio(null, "Regeneração", uf17);
		Municipio mun4150 = new Municipio(null, "Riacho Frio", uf17);
		Municipio mun4158 = new Municipio(null, "Ribeira do Piauí", uf17);
		Municipio mun4177 = new Municipio(null, "Ribeiro Gonçalves", uf17);
		Municipio mun4219 = new Municipio(null, "Rio Grande do Piauí", uf17);
		Municipio mun4374 = new Municipio(null, "Santa Cruz do Piauí", uf17);
		Municipio mun4378 = new Municipio(null, "Santa Cruz dos Milagres", uf17);
		Municipio mun4391 = new Municipio(null, "Santa Filomena", uf17);
		Municipio mun4413 = new Municipio(null, "Santa Luz", uf17);
		Municipio mun4467 = new Municipio(null, "Santa Rosa do Piauí", uf17);
		Municipio mun4511 = new Municipio(null, "Santana do Piauí", uf17);
		Municipio mun4541 = new Municipio(null, "Santo Antônio de Lisboa", uf17);
		Municipio mun4566 = new Municipio(null, "Santo Antônio dos Milagres", uf17);
		Municipio mun4574 = new Municipio(null, "Santo Inácio do Piauí", uf17);
		Municipio mun4599 = new Municipio(null, "São Braz do Piauí", uf17);
		Municipio mun4629 = new Municipio(null, "São Félix do Piauí", uf17);
		Municipio mun4635 = new Municipio(null, "São Francisco de Assis do Piauí", uf17);
		Municipio mun4649 = new Municipio(null, "São Francisco do Piauí", uf17);
		Municipio mun4667 = new Municipio(null, "São Gonçalo do Gurguéia", uf17);
		Municipio mun4669 = new Municipio(null, "São Gonçalo do Piauí", uf17);
		Municipio mun4685 = new Municipio(null, "São João da Canabrava", uf17);
		Municipio mun4686 = new Municipio(null, "São João da Fronteira", uf17);
		Municipio mun4692 = new Municipio(null, "São João da Serra", uf17);
		Municipio mun4694 = new Municipio(null, "São João da Varjota", uf17);
		Municipio mun4702 = new Municipio(null, "São João do Arraial", uf17);
		Municipio mun4717 = new Municipio(null, "São João do Piauí", uf17);
		Municipio mun4768 = new Municipio(null, "São José do Divino", uf17);
		Municipio mun4779 = new Municipio(null, "São José do Peixe", uf17);
		Municipio mun4780 = new Municipio(null, "São José do Piauí", uf17);
		Municipio mun4798 = new Municipio(null, "São Julião", uf17);
		Municipio mun4803 = new Municipio(null, "São Lourenço do Piauí", uf17);
		Municipio mun4810 = new Municipio(null, "São Luis do Piauí", uf17);
		Municipio mun4828 = new Municipio(null, "São Miguel da Baixa Grande", uf17);
		Municipio mun4836 = new Municipio(null, "São Miguel do Fidalgo", uf17);
		Municipio mun4843 = new Municipio(null, "São Miguel do Tapuio", uf17);
		Municipio mun4865 = new Municipio(null, "São Pedro do Piauí", uf17);
		Municipio mun4876 = new Municipio(null, "São Raimundo Nonato", uf17);
		Municipio mun4949 = new Municipio(null, "Sebastião Barros", uf17);
		Municipio mun4951 = new Municipio(null, "Sebastião Leal", uf17);
		Municipio mun5041 = new Municipio(null, "Sigefredo Pacheco", uf17);
		Municipio mun5053 = new Municipio(null, "Simões", uf17);
		Municipio mun5056 = new Municipio(null, "Simplício Mendes", uf17);
		Municipio mun5073 = new Municipio(null, "Socorro do Piauí", uf17);
		Municipio mun5100 = new Municipio(null, "Sussuapara", uf17);
		Municipio mun5132 = new Municipio(null, "Tamboril do Piauí", uf17);
		Municipio mun5141 = new Municipio(null, "Tanque do Piauí", uf17);
		Municipio mun5205 = new Municipio(null, "Teresina", uf17);
		Municipio mun5379 = new Municipio(null, "União", uf17);
		Municipio mun5397 = new Municipio(null, "Uruçuí", uf17);
		Municipio mun5415 = new Municipio(null, "Valença do Piauí", uf17);
		Municipio mun5441 = new Municipio(null, "Várzea Branca", uf17);
		Municipio mun5446 = new Municipio(null, "Várzea Grande", uf17);
		Municipio mun5465 = new Municipio(null, "Vera Mendes", uf17);
		Municipio mun5504 = new Municipio(null, "Vila Nova do Piauí", uf17);
		Municipio mun5543 = new Municipio(null, "Wall Ferraz", uf17);

		municipioRepository.saveAll(Arrays.asList(mun1043, mun1072, mun1074, mun1088, mun1100, mun1113, mun1174, mun1206, 
			mun1287, mun1289, mun1290, mun1299, mun1312, mun1313, mun1334, mun1404, 
			mun1419, mun1457, mun1465, mun1506, mun1512, mun1515, mun1518, mun1540, 
			mun1567, mun1596, mun1598, mun1607, mun1649, mun1651, mun1698, mun1745, 
			mun1802, mun1806, mun1812, mun1844, mun1846, mun1851, mun1854, mun1868, 
			mun1898, mun1909, mun1977, mun2033, mun2069, mun2169, mun2212, mun2237, 
			mun194, mun239, mun250, mun258, mun388, mun389, mun392, mun413, 
			mun2280, mun2319, mun2426, mun2481, mun2506, mun2541, mun2556, mun2576, 
			mun24, mun43, mun50, mun90, mun104, mun156, mun169, mun180, 
			mun2590, mun2602, mun2604, mun2612, mun2624, mun2632, mun2651, mun2680, 
			mun2688, mun2690, mun2695, mun2696, mun2715, mun2737, mun2807, mun2824, 
			mun2849, mun2898, mun2941, mun2942, mun2987, mun3005, mun3054, mun3056, 
			mun3063, mun3122, mun3123, mun3134, mun3183, mun3186, mun3223, mun3248, 
			mun3281, mun3284, mun3372, mun3411, mun3417, mun3428, mun3435, mun3503, 
			mun3505, mun3514, mun3532, mun3536, mun3561, mun3616, mun3617, mun3627, 
			mun3644, mun3652, mun3665, mun3677, mun3717, mun3718, mun3769, mun3788, 
			mun3816, mun3825, mun3856, mun3942, mun3976, mun4000, mun4065, mun4110, 
			mun4115, mun4150, mun4158, mun4177, mun4219, mun4374, mun4378, mun4391, 
			mun4413, mun4467, mun4511, mun4541, mun4566, mun4574, mun4599, mun4629, 
			mun442, mun459, mun506, mun538, mun540, mun549, mun561, mun575, 
			mun4635, mun4649, mun4667, mun4669, mun4685, mun4686, mun4692, mun4694, 
			mun4702, mun4717, mun4768, mun4779, mun4780, mun4798, mun4803, mun4810, 
			mun4828, mun4836, mun4843, mun4865, mun4876, mun4949, mun4951, mun5041, 
			mun5053, mun5056, mun5073, mun5100, mun5132, mun5141, mun5205, mun5379, 
			mun5397, mun5415, mun5441, mun5446, mun5465, mun5504, mun5543, 
			mun582, mun597, mun614, mun617, mun636, mun656, mun689, mun694, 
			mun706, mun720, mun753, mun770, mun803, mun804, mun822, mun894, 
			mun898, mun908, mun950, mun956, mun971, mun974, mun979, mun1010));

	}
	
	private void instanciaMunUf18(UF uf18) {
		Municipio mun10 = new Municipio(null, "Abatiá", uf18);
		Municipio mun35 = new Municipio(null, "Adrianópolis", uf18);
		Municipio mun77 = new Municipio(null, "Agudos do Sul", uf18);
		Municipio mun126 = new Municipio(null, "Almirante Tamandaré", uf18);
		Municipio mun135 = new Municipio(null, "Altamira do Paraná", uf18);
		Municipio mun159 = new Municipio(null, "Alto Paraíso", uf18);
		Municipio mun161 = new Municipio(null, "Alto Paraná", uf18);
		Municipio mun163 = new Municipio(null, "Alto Piquiri", uf18);
		Municipio mun168 = new Municipio(null, "Altônia", uf18);
		Municipio mun182 = new Municipio(null, "Alvorada do Sul", uf18);
		Municipio mun189 = new Municipio(null, "Amaporã", uf18);
		Municipio mun210 = new Municipio(null, "Ampére", uf18);
		Municipio mun213 = new Municipio(null, "Anahy", uf18);
		Municipio mun228 = new Municipio(null, "Andirá", uf18);
		Municipio mun245 = new Municipio(null, "Ângulo", uf18);
		Municipio mun257 = new Municipio(null, "Antonina", uf18);
		Municipio mun266 = new Municipio(null, "Antônio Olinto", uf18);
		Municipio mun286 = new Municipio(null, "Apucarana", uf18);
		Municipio mun334 = new Municipio(null, "Arapongas", uf18);
		Municipio mun336 = new Municipio(null, "Arapoti", uf18);
		Municipio mun338 = new Municipio(null, "Arapuã", uf18);
		Municipio mun352 = new Municipio(null, "Araruna", uf18);
		Municipio mun358 = new Municipio(null, "Araucária", uf18);
		Municipio mun383 = new Municipio(null, "Ariranha do Ivaí", uf18);
		Municipio mun408 = new Municipio(null, "Assaí", uf18);
		Municipio mun411 = new Municipio(null, "Assis Chateaubriand", uf18);
		Municipio mun416 = new Municipio(null, "Astorga", uf18);
		Municipio mun418 = new Municipio(null, "Atalaia", uf18);
		Municipio mun471 = new Municipio(null, "Balsa Nova", uf18);
		Municipio mun483 = new Municipio(null, "Bandeirantes", uf18);
		Municipio mun498 = new Municipio(null, "Barbosa Ferraz", uf18);
		Municipio mun521 = new Municipio(null, "Barra do Jacaré", uf18);
		Municipio mun536 = new Municipio(null, "Barracão", uf18);
		Municipio mun570 = new Municipio(null, "Bela Vista da Caroba", uf18);
		Municipio mun574 = new Municipio(null, "Bela Vista do Paraíso", uf18);
		Municipio mun629 = new Municipio(null, "Bituruna", uf18);
		Municipio mun631 = new Municipio(null, "Boa Esperança do Iguaçu", uf18);
		Municipio mun634 = new Municipio(null, "Boa Esperança", uf18);
		Municipio mun638 = new Municipio(null, "Boa Ventura de São Roque", uf18);
		Municipio mun641 = new Municipio(null, "Boa Vista da Aparecida", uf18);
		Municipio mun658 = new Municipio(null, "Bocaiúva do Sul", uf18);
		Municipio mun684 = new Municipio(null, "Bom Jesus do Sul", uf18);
		Municipio mun701 = new Municipio(null, "Bom Sucesso do Sul", uf18);
		Municipio mun704 = new Municipio(null, "Bom Sucesso", uf18);
		Municipio mun731 = new Municipio(null, "Borrazópolis", uf18);
		Municipio mun744 = new Municipio(null, "Braganey", uf18);
		Municipio mun749 = new Municipio(null, "Brasilândia do Sul", uf18);
		Municipio mun873 = new Municipio(null, "Cafeara", uf18);
		Municipio mun874 = new Municipio(null, "Cafelândia", uf18);
		Municipio mun876 = new Municipio(null, "Cafezal do Sul", uf18);
		Municipio mun910 = new Municipio(null, "Califórnia", uf18);
		Municipio mun924 = new Municipio(null, "Cambará", uf18);
		Municipio mun925 = new Municipio(null, "Cambé", uf18);
		Municipio mun926 = new Municipio(null, "Cambira", uf18);
		Municipio mun941 = new Municipio(null, "Campina da Lagoa", uf18);
		Municipio mun944 = new Municipio(null, "Campina do Simão", uf18);
		Municipio mun945 = new Municipio(null, "Campina Grande do Sul", uf18);
		Municipio mun963 = new Municipio(null, "Campo Bonito", uf18);
		Municipio mun967 = new Municipio(null, "Campo do Tenente", uf18);
		Municipio mun975 = new Municipio(null, "Campo Largo", uf18);
		Municipio mun978 = new Municipio(null, "Campo Magro", uf18);
		Municipio mun980 = new Municipio(null, "Campo Mourão", uf18);
		Municipio mun1018 = new Municipio(null, "Cândido de Abreu", uf18);
		Municipio mun1025 = new Municipio(null, "Candói", uf18);
		Municipio mun1040 = new Municipio(null, "Cantagalo", uf18);
		Municipio mun1048 = new Municipio(null, "Capanema", uf18);
		Municipio mun1075 = new Municipio(null, "Capitão Leônidas Marques", uf18);
		Municipio mun1092 = new Municipio(null, "Carambeí", uf18);
		Municipio mun1122 = new Municipio(null, "Carlópolis", uf18);
		Municipio mun1160 = new Municipio(null, "Cascavel", uf18);
		Municipio mun1178 = new Municipio(null, "Castro", uf18);
		Municipio mun1182 = new Municipio(null, "Catanduvas", uf18);
		Municipio mun1215 = new Municipio(null, "Centenário do Sul", uf18);
		Municipio mun1229 = new Municipio(null, "Cerro Azul", uf18);
		Municipio mun1237 = new Municipio(null, "Céu Azul", uf18);
		Municipio mun1263 = new Municipio(null, "Chopinzinho", uf18);
		Municipio mun1270 = new Municipio(null, "Cianorte", uf18);
		Municipio mun1272 = new Municipio(null, "Cidade Gaúcha", uf18);
		Municipio mun1284 = new Municipio(null, "Clevelândia", uf18);
		Municipio mun1311 = new Municipio(null, "Colombo", uf18);
		Municipio mun1316 = new Municipio(null, "Colorado", uf18);
		Municipio mun1362 = new Municipio(null, "Congonhinhas", uf18);
		Municipio mun1366 = new Municipio(null, "Conselheiro Mairinck", uf18);
		Municipio mun1371 = new Municipio(null, "Contenda", uf18);
		Municipio mun1379 = new Municipio(null, "Corbélia", uf18);
		Municipio mun1391 = new Municipio(null, "Cornélio Procópio", uf18);
		Municipio mun1398 = new Municipio(null, "Coronel Domingos Soares", uf18);
		Municipio mun1411 = new Municipio(null, "Coronel Vivida", uf18);
		Municipio mun1426 = new Municipio(null, "Corumbataí do Sul", uf18);
		Municipio mun1475 = new Municipio(null, "Cruz Machado", uf18);
		Municipio mun1480 = new Municipio(null, "Cruzeiro do Iguaçu", uf18);
		Municipio mun1481 = new Municipio(null, "Cruzeiro do Oeste", uf18);
		Municipio mun1483 = new Municipio(null, "Cruzeiro do Sul", uf18);
		Municipio mun1488 = new Municipio(null, "Cruzmaltina", uf18);
		Municipio mun1508 = new Municipio(null, "Curitiba", uf18);
		Municipio mun1510 = new Municipio(null, "Curiúva", uf18);
		Municipio mun1553 = new Municipio(null, "Diamante d'Oeste", uf18);
		Municipio mun1554 = new Municipio(null, "Diamante do Norte", uf18);
		Municipio mun1555 = new Municipio(null, "Diamante do Sul", uf18);
		Municipio mun1589 = new Municipio(null, "Dois Vizinhos", uf18);
		Municipio mun1620 = new Municipio(null, "Douradina", uf18);
		Municipio mun1624 = new Municipio(null, "Doutor Camargo", uf18);
		Municipio mun1629 = new Municipio(null, "Doutor Ulysses", uf18);
		Municipio mun1664 = new Municipio(null, "Enéas Marques", uf18);
		Municipio mun1665 = new Municipio(null, "Engenheiro Beltrão", uf18);
		Municipio mun1673 = new Municipio(null, "Entre Rios do Oeste", uf18);
		Municipio mun1696 = new Municipio(null, "Esperança Nova", uf18);
		Municipio mun1701 = new Municipio(null, "Espigão Alto do Iguaçu", uf18);
		Municipio mun1743 = new Municipio(null, "Farol", uf18);
		Municipio mun1752 = new Municipio(null, "Faxinal", uf18);
		Municipio mun1755 = new Municipio(null, "Fazenda Rio Grande", uf18);
		Municipio mun1771 = new Municipio(null, "Fênix", uf18);
		Municipio mun1772 = new Municipio(null, "Fernandes Pinheiro", uf18);
		Municipio mun1785 = new Municipio(null, "Figueira", uf18);
		Municipio mun1794 = new Municipio(null, "Flor da Serra do Sul", uf18);
		Municipio mun1797 = new Municipio(null, "Floraí", uf18);
		Municipio mun1808 = new Municipio(null, "Floresta", uf18);
		Municipio mun1810 = new Municipio(null, "Florestópolis", uf18);
		Municipio mun1815 = new Municipio(null, "Flórida", uf18);
		Municipio mun1822 = new Municipio(null, "Formosa do Oeste", uf18);
		Municipio mun1840 = new Municipio(null, "Foz do Iguaçu", uf18);
		Municipio mun1841 = new Municipio(null, "Foz do Jordão", uf18);
		Municipio mun1845 = new Municipio(null, "Francisco Alves", uf18);
		Municipio mun1848 = new Municipio(null, "Francisco Beltrão", uf18);
		Municipio mun1901 = new Municipio(null, "General Carneiro", uf18);
		Municipio mun1920 = new Municipio(null, "Godoy Moreira", uf18);
		Municipio mun1935 = new Municipio(null, "Goioerê", uf18);
		Municipio mun1936 = new Municipio(null, "Goioxim", uf18);
		Municipio mun1962 = new Municipio(null, "Grandes Rios", uf18);
		Municipio mun1981 = new Municipio(null, "Guaíra", uf18);
		Municipio mun1983 = new Municipio(null, "Guairaçá", uf18);
		Municipio mun1989 = new Municipio(null, "Guamiranga", uf18);
		Municipio mun1996 = new Municipio(null, "Guapirama", uf18);
		Municipio mun1999 = new Municipio(null, "Guaporema", uf18);
		Municipio mun2003 = new Municipio(null, "Guaraci", uf18);
		Municipio mun2018 = new Municipio(null, "Guaraniaçu", uf18);
		Municipio mun2022 = new Municipio(null, "Guarapuava", uf18);
		Municipio mun2023 = new Municipio(null, "Guaraqueçaba", uf18);
		Municipio mun2029 = new Municipio(null, "Guaratuba", uf18);
		Municipio mun2065 = new Municipio(null, "Honório Serpa", uf18);
		Municipio mun2081 = new Municipio(null, "Ibaiti", uf18);
		Municipio mun2087 = new Municipio(null, "Ibema", uf18);
		Municipio mun2104 = new Municipio(null, "Ibiporã", uf18);
		Municipio mun2131 = new Municipio(null, "Icaraíma", uf18);
		Municipio mun2159 = new Municipio(null, "Iguaraçu", uf18);
		Municipio mun2162 = new Municipio(null, "Iguatu", uf18);
		Municipio mun2178 = new Municipio(null, "Imbaú", uf18);
		Municipio mun2182 = new Municipio(null, "Imbituva", uf18);
		Municipio mun2186 = new Municipio(null, "Inácio Martins", uf18);
		Municipio mun2189 = new Municipio(null, "Inajá", uf18);
		Municipio mun2198 = new Municipio(null, "Indianópolis", uf18);
		Municipio mun2239 = new Municipio(null, "Ipiranga", uf18);
		Municipio mun2244 = new Municipio(null, "Iporã", uf18);
		Municipio mun2257 = new Municipio(null, "Iracema do Oeste", uf18);
		Municipio mun2272 = new Municipio(null, "Irati", uf18);
		Municipio mun2276 = new Municipio(null, "Iretama", uf18);
		Municipio mun2311 = new Municipio(null, "Itaguajé", uf18);
		Municipio mun2323 = new Municipio(null, "Itaipulândia", uf18);
		Municipio mun2341 = new Municipio(null, "Itambaracá", uf18);
		Municipio mun2344 = new Municipio(null, "Itambé", uf18);
		Municipio mun2366 = new Municipio(null, "Itapejara d'Oeste", uf18);
		Municipio mun2369 = new Municipio(null, "Itaperuçu", uf18);
		Municipio mun2427 = new Municipio(null, "Itaúna do Sul", uf18);
		Municipio mun2454 = new Municipio(null, "Ivaí", uf18);
		Municipio mun2455 = new Municipio(null, "Ivaiporã", uf18);
		Municipio mun2456 = new Municipio(null, "Ivaté", uf18);
		Municipio mun2457 = new Municipio(null, "Ivatuba", uf18);
		Municipio mun2466 = new Municipio(null, "Jaboti", uf18);
		Municipio mun2476 = new Municipio(null, "Jacarezinho", uf18);
		Municipio mun2490 = new Municipio(null, "Jaguapitã", uf18);
		Municipio mun2498 = new Municipio(null, "Jaguariaíva", uf18);
		Municipio mun2511 = new Municipio(null, "Jandaia do Sul", uf18);
		Municipio mun2518 = new Municipio(null, "Janiópolis", uf18);
		Municipio mun2526 = new Municipio(null, "Japira", uf18);
		Municipio mun2530 = new Municipio(null, "Japurá", uf18);
		Municipio mun2538 = new Municipio(null, "Jardim Alegre", uf18);
		Municipio mun2543 = new Municipio(null, "Jardim Olinda", uf18);
		Municipio mun2552 = new Municipio(null, "Jataizinho", uf18);
		Municipio mun2578 = new Municipio(null, "Jesuítas", uf18);
		Municipio mun2603 = new Municipio(null, "Joaquim Távora", uf18);
		Municipio mun2640 = new Municipio(null, "Jundiaí do Sul", uf18);
		Municipio mun2649 = new Municipio(null, "Juranda", uf18);
		Municipio mun2659 = new Municipio(null, "Jussara", uf18);
		Municipio mun2667 = new Municipio(null, "Kaloré", uf18);
		Municipio mun2738 = new Municipio(null, "Lapa", uf18);
		Municipio mun2744 = new Municipio(null, "Laranjal", uf18);
		Municipio mun2745 = new Municipio(null, "Laranjeiras do Sul", uf18);
		Municipio mun2767 = new Municipio(null, "Leópolis", uf18);
		Municipio mun2771 = new Municipio(null, "Lidianópolis", uf18);
		Municipio mun2780 = new Municipio(null, "Lindoeste", uf18);
		Municipio mun2790 = new Municipio(null, "Loanda", uf18);
		Municipio mun2791 = new Municipio(null, "Lobato", uf18);
		Municipio mun2793 = new Municipio(null, "Londrina", uf18);
		Municipio mun2814 = new Municipio(null, "Luiziana", uf18);
		Municipio mun2817 = new Municipio(null, "Lunardelli", uf18);
		Municipio mun2819 = new Municipio(null, "Lupionópolis", uf18);
		Municipio mun2874 = new Municipio(null, "Mallet", uf18);
		Municipio mun2878 = new Municipio(null, "Mamborê", uf18);
		Municipio mun2887 = new Municipio(null, "Mandaguaçu", uf18);
		Municipio mun2888 = new Municipio(null, "Mandaguari", uf18);
		Municipio mun2889 = new Municipio(null, "Mandirituba", uf18);
		Municipio mun2891 = new Municipio(null, "Manfrinópolis", uf18);
		Municipio mun2894 = new Municipio(null, "Mangueirinha", uf18);
		Municipio mun2899 = new Municipio(null, "Manoel Ribas", uf18);
		Municipio mun2943 = new Municipio(null, "Marechal Cândido Rondon", uf18);
		Municipio mun2950 = new Municipio(null, "Maria Helena", uf18);
		Municipio mun2951 = new Municipio(null, "Marialva", uf18);
		Municipio mun2960 = new Municipio(null, "Marilândia do Sul", uf18);
		Municipio mun2962 = new Municipio(null, "Marilena", uf18);
		Municipio mun2964 = new Municipio(null, "Mariluz", uf18);
		Municipio mun2965 = new Municipio(null, "Maringá", uf18);
		Municipio mun2968 = new Municipio(null, "Mariópolis", uf18);
		Municipio mun2970 = new Municipio(null, "Maripá", uf18);
		Municipio mun2974 = new Municipio(null, "Marmeleiro", uf18);
		Municipio mun2977 = new Municipio(null, "Marquinho", uf18);
		Municipio mun2984 = new Municipio(null, "Marumbi", uf18);
		Municipio mun2999 = new Municipio(null, "Matelândia", uf18);
		Municipio mun3009 = new Municipio(null, "Matinhos", uf18);
		Municipio mun3015 = new Municipio(null, "Mato Rico", uf18);
		Municipio mun3026 = new Municipio(null, "Mauá da Serra", uf18);
		Municipio mun3037 = new Municipio(null, "Medianeira", uf18);
		Municipio mun3045 = new Municipio(null, "Mercedes", uf18);
		Municipio mun3080 = new Municipio(null, "Mirador", uf18);
		Municipio mun3094 = new Municipio(null, "Miraselva", uf18);
		Municipio mun3101 = new Municipio(null, "Missal", uf18);
		Municipio mun3173 = new Municipio(null, "Moreira Sales", uf18);
		Municipio mun3177 = new Municipio(null, "Morretes", uf18);
		Municipio mun3215 = new Municipio(null, "Munhoz de Melo", uf18);
		Municipio mun3279 = new Municipio(null, "Nossa Senhora das Graças", uf18);
		Municipio mun3285 = new Municipio(null, "Nova Aliança do Ivaí", uf18);
		Municipio mun3289 = new Municipio(null, "Nova América da Colina", uf18);
		Municipio mun3293 = new Municipio(null, "Nova Aurora", uf18);
		Municipio mun3307 = new Municipio(null, "Nova Cantu", uf18);
		Municipio mun3315 = new Municipio(null, "Nova Esperança do Sudoeste", uf18);
		Municipio mun3317 = new Municipio(null, "Nova Esperança", uf18);
		Municipio mun3319 = new Municipio(null, "Nova Fátima", uf18);
		Municipio mun3337 = new Municipio(null, "Nova Laranjeiras", uf18);
		Municipio mun3339 = new Municipio(null, "Nova Londrina", uf18);
		Municipio mun3349 = new Municipio(null, "Nova Olímpia", uf18);
		Municipio mun3361 = new Municipio(null, "Nova Prata do Iguaçu", uf18);
		Municipio mun3370 = new Municipio(null, "Nova Santa Bárbara", uf18);
		Municipio mun3374 = new Municipio(null, "Nova Santa Rosa", uf18);
		Municipio mun3377 = new Municipio(null, "Nova Tebas", uf18);
		Municipio mun3405 = new Municipio(null, "Novo Itacolomi", uf18);
		Municipio mun3464 = new Municipio(null, "Ortigueira", uf18);
		Municipio mun3475 = new Municipio(null, "Ourizona", uf18);
		Municipio mun3485 = new Municipio(null, "Ouro Verde do Oeste", uf18);
		Municipio mun3508 = new Municipio(null, "Paiçandu", uf18);
		Municipio mun3528 = new Municipio(null, "Palmas", uf18);
		Municipio mun3534 = new Municipio(null, "Palmeira", uf18);
		Municipio mun3546 = new Municipio(null, "Palmital", uf18);
		Municipio mun3551 = new Municipio(null, "Palotina", uf18);
		Municipio mun3574 = new Municipio(null, "Paraíso do Norte", uf18);
		Municipio mun3585 = new Municipio(null, "Paranacity", uf18);
		Municipio mun3586 = new Municipio(null, "Paranaguá", uf18);
		Municipio mun3591 = new Municipio(null, "Paranapoema", uf18);
		Municipio mun3595 = new Municipio(null, "Paranavaí", uf18);
		Municipio mun3641 = new Municipio(null, "Pato Bragado", uf18);
		Municipio mun3642 = new Municipio(null, "Pato Branco", uf18);
		Municipio mun3659 = new Municipio(null, "Paula Freitas", uf18);
		Municipio mun3671 = new Municipio(null, "Paulo Frontin", uf18);
		Municipio mun3679 = new Municipio(null, "Peabiru", uf18);
		Municipio mun3749 = new Municipio(null, "Perobal", uf18);
		Municipio mun3750 = new Municipio(null, "Pérola d'Oeste", uf18);
		Municipio mun3751 = new Municipio(null, "Pérola", uf18);
		Municipio mun3776 = new Municipio(null, "Piên", uf18);
		Municipio mun3798 = new Municipio(null, "Pinhais", uf18);
		Municipio mun3800 = new Municipio(null, "Pinhal de São Bento", uf18);
		Municipio mun3803 = new Municipio(null, "Pinhalão", uf18);
		Municipio mun3806 = new Municipio(null, "Pinhão", uf18);
		Municipio mun3827 = new Municipio(null, "Piraí do Sul", uf18);
		Municipio mun3845 = new Municipio(null, "Piraquara", uf18);
		Municipio mun3859 = new Municipio(null, "Pitanga", uf18);
		Municipio mun3860 = new Municipio(null, "Pitangueiras", uf18);
		Municipio mun3869 = new Municipio(null, "Planaltina do Paraná", uf18);
		Municipio mun3874 = new Municipio(null, "Planalto", uf18);
		Municipio mun3905 = new Municipio(null, "Ponta Grossa", uf18);
		Municipio mun3908 = new Municipio(null, "Pontal do Paraná", uf18);
		Municipio mun3932 = new Municipio(null, "Porecatu", uf18);
		Municipio mun3945 = new Municipio(null, "Porto Amazonas", uf18);
		Municipio mun3946 = new Municipio(null, "Porto Barreiro", uf18);
		Municipio mun3968 = new Municipio(null, "Porto Rico", uf18);
		Municipio mun3973 = new Municipio(null, "Porto Vitória", uf18);
		Municipio mun3991 = new Municipio(null, "Prado Ferreira", uf18);
		Municipio mun3999 = new Municipio(null, "Pranchita", uf18);
		Municipio mun4009 = new Municipio(null, "Presidente Castelo Branco", uf18);
		Municipio mun4038 = new Municipio(null, "Primeiro de Maio", uf18);
		Municipio mun4047 = new Municipio(null, "Prudentópolis", uf18);
		Municipio mun4055 = new Municipio(null, "Quarto Centenário", uf18);
		Municipio mun4057 = new Municipio(null, "Quatiguá", uf18);
		Municipio mun4060 = new Municipio(null, "Quatro Barras", uf18);
		Municipio mun4062 = new Municipio(null, "Quatro Pontes", uf18);
		Municipio mun4064 = new Municipio(null, "Quedas do Iguaçu", uf18);
		Municipio mun4072 = new Municipio(null, "Querência do Norte", uf18);
		Municipio mun4077 = new Municipio(null, "Quinta do Sol", uf18);
		Municipio mun4083 = new Municipio(null, "Quitandinha", uf18);
		Municipio mun4096 = new Municipio(null, "Ramilândia", uf18);
		Municipio mun4098 = new Municipio(null, "Rancho Alegre d'Oeste", uf18);
		Municipio mun4099 = new Municipio(null, "Rancho Alegre", uf18);
		Municipio mun4104 = new Municipio(null, "Realeza", uf18);
		Municipio mun4105 = new Municipio(null, "Rebouças", uf18);
		Municipio mun4122 = new Municipio(null, "Renascença", uf18);
		Municipio mun4127 = new Municipio(null, "Reserva do Iguaçu", uf18);
		Municipio mun4128 = new Municipio(null, "Reserva", uf18);
		Municipio mun4164 = new Municipio(null, "Ribeirão Claro", uf18);
		Municipio mun4168 = new Municipio(null, "Ribeirão do Pinhal", uf18);
		Municipio mun4183 = new Municipio(null, "Rio Azul", uf18);
		Municipio mun4185 = new Municipio(null, "Rio Bom", uf18);
		Municipio mun4186 = new Municipio(null, "Rio Bonito do Iguaçu", uf18);
		Municipio mun4188 = new Municipio(null, "Rio Branco do Ivaí", uf18);
		Municipio mun4189 = new Municipio(null, "Rio Branco do Sul", uf18);
		Municipio mun4226 = new Municipio(null, "Rio Negro", uf18);
		Municipio mun4259 = new Municipio(null, "Rolândia", uf18);
		Municipio mun4264 = new Municipio(null, "Roncador", uf18);
		Municipio mun4269 = new Municipio(null, "Rondon", uf18);
		Municipio mun4276 = new Municipio(null, "Rosário do Ivaí", uf18);
		Municipio mun4292 = new Municipio(null, "Sabáudia", uf18);
		Municipio mun4308 = new Municipio(null, "Salgado Filho", uf18);
		Municipio mun4322 = new Municipio(null, "Salto do Itararé", uf18);
		Municipio mun4324 = new Municipio(null, "Salto do Lontra", uf18);
		Municipio mun4342 = new Municipio(null, "Santa Amélia", uf18);
		Municipio mun4355 = new Municipio(null, "Santa Cecília do Pavão", uf18);
		Municipio mun4369 = new Municipio(null, "Santa Cruz de Monte Castelo", uf18);
		Municipio mun4388 = new Municipio(null, "Santa Fé", uf18);
		Municipio mun4397 = new Municipio(null, "Santa Helena", uf18);
		Municipio mun4401 = new Municipio(null, "Santa Inês", uf18);
		Municipio mun4403 = new Municipio(null, "Santa Isabel do Ivaí", uf18);
		Municipio mun4408 = new Municipio(null, "Santa Izabel do Oeste", uf18);
		Municipio mun4411 = new Municipio(null, "Santa Lúcia", uf18);
		Municipio mun4433 = new Municipio(null, "Santa Maria do Oeste", uf18);
		Municipio mun4441 = new Municipio(null, "Santa Mariana", uf18);
		Municipio mun4443 = new Municipio(null, "Santa Mônica", uf18);
		Municipio mun4477 = new Municipio(null, "Santa Tereza do Oeste", uf18);
		Municipio mun4481 = new Municipio(null, "Santa Terezinha de Itaipu", uf18);
		Municipio mun4503 = new Municipio(null, "Santana do Itararé", uf18);
		Municipio mun4537 = new Municipio(null, "Santo Antônio da Platina", uf18);
		Municipio mun4547 = new Municipio(null, "Santo Antônio do Caiuá", uf18);
		Municipio mun4558 = new Municipio(null, "Santo Antônio do Paraíso", uf18);
		Municipio mun4563 = new Municipio(null, "Santo Antônio do Sudoeste", uf18);
		Municipio mun4575 = new Municipio(null, "Santo Inácio", uf18);
		Municipio mun4603 = new Municipio(null, "São Carlos do Ivaí", uf18);
		Municipio mun4676 = new Municipio(null, "São Jerônimo da Serra", uf18);
		Municipio mun4703 = new Municipio(null, "São João do Caiuá", uf18);
		Municipio mun4707 = new Municipio(null, "São João do Ivaí", uf18);
		Municipio mun4724 = new Municipio(null, "São João do Triunfo", uf18);
		Municipio mun4729 = new Municipio(null, "São João", uf18);
		Municipio mun4734 = new Municipio(null, "São Jorge d'Oeste", uf18);
		Municipio mun4735 = new Municipio(null, "São Jorge do Ivaí", uf18);
		Municipio mun4736 = new Municipio(null, "São Jorge do Patrocínio", uf18);
		Municipio mun4740 = new Municipio(null, "São José da Boa Vista", uf18);
		Municipio mun4750 = new Municipio(null, "São José das Palmeiras", uf18);
		Municipio mun4794 = new Municipio(null, "São José dos Pinhais", uf18);
		Municipio mun4818 = new Municipio(null, "São Manoel do Paraná", uf18);
		Municipio mun4825 = new Municipio(null, "São Mateus do Sul", uf18);
		Municipio mun4840 = new Municipio(null, "São Miguel do Iguaçu", uf18);
		Municipio mun4862 = new Municipio(null, "São Pedro do Iguaçu", uf18);
		Municipio mun4863 = new Municipio(null, "São Pedro do Ivaí", uf18);
		Municipio mun4864 = new Municipio(null, "São Pedro do Paraná", uf18);
		Municipio mun4883 = new Municipio(null, "São Sebastião da Amoreira", uf18);
		Municipio mun4909 = new Municipio(null, "São Tomé", uf18);
		Municipio mun4926 = new Municipio(null, "Sapopema", uf18);
		Municipio mun4932 = new Municipio(null, "Sarandi", uf18);
		Municipio mun4942 = new Municipio(null, "Saudade do Iguaçu", uf18);
		Municipio mun4975 = new Municipio(null, "Sengés", uf18);
		Municipio mun5014 = new Municipio(null, "Serranópolis do Iguaçu", uf18);
		Municipio mun5024 = new Municipio(null, "Sertaneja", uf18);
		Municipio mun5026 = new Municipio(null, "Sertanópolis", uf18);
		Municipio mun5059 = new Municipio(null, "Siqueira Campos", uf18);
		Municipio mun5095 = new Municipio(null, "Sulina", uf18);
		Municipio mun5129 = new Municipio(null, "Tamarana", uf18);
		Municipio mun5131 = new Municipio(null, "Tamboara", uf18);
		Municipio mun5146 = new Municipio(null, "Tapejara", uf18);
		Municipio mun5153 = new Municipio(null, "Tapira", uf18);
		Municipio mun5185 = new Municipio(null, "Teixeira Soares", uf18);
		Municipio mun5191 = new Municipio(null, "Telêmaco Borba", uf18);
		Municipio mun5210 = new Municipio(null, "Terra Boa", uf18);
		Municipio mun5215 = new Municipio(null, "Terra Rica", uf18);
		Municipio mun5216 = new Municipio(null, "Terra Roxa", uf18);
		Municipio mun5223 = new Municipio(null, "Tibagi", uf18);
		Municipio mun5228 = new Municipio(null, "Tijucas do Sul", uf18);
		Municipio mun5249 = new Municipio(null, "Toledo", uf18);
		Municipio mun5251 = new Municipio(null, "Tomazina", uf18);
		Municipio mun5274 = new Municipio(null, "Três Barras do Paraná", uf18);
		Municipio mun5311 = new Municipio(null, "Tunas do Paraná", uf18);
		Municipio mun5313 = new Municipio(null, "Tuneiras do Oeste", uf18);
		Municipio mun5323 = new Municipio(null, "Tupãssi", uf18);
		Municipio mun5336 = new Municipio(null, "Turvo", uf18);
		Municipio mun5354 = new Municipio(null, "Ubiratã", uf18);
		Municipio mun5369 = new Municipio(null, "Umuarama", uf18);
		Municipio mun5373 = new Municipio(null, "União da Vitória", uf18);
		Municipio mun5380 = new Municipio(null, "Uniflor", uf18);
		Municipio mun5383 = new Municipio(null, "Uraí", uf18);
		Municipio mun5458 = new Municipio(null, "Ventania", uf18);
		Municipio mun5460 = new Municipio(null, "Vera Cruz do Oeste", uf18);
		Municipio mun5470 = new Municipio(null, "Verê", uf18);
		Municipio mun5519 = new Municipio(null, "Virmond", uf18);
		Municipio mun5537 = new Municipio(null, "Vitorino", uf18);
		Municipio mun5547 = new Municipio(null, "Wenceslau Braz", uf18);
		Municipio mun5552 = new Municipio(null, "Xambrê", uf18);

		municipioRepository.saveAll(Arrays.asList(mun10, mun35, mun77, mun126, mun135, mun159, mun161, mun163, 
			mun1040, mun1048, mun1075, mun1092, mun1122, mun1160, mun1178, mun1182, 
			mun1215, mun1229, mun1237, mun1263, mun1270, mun1272, mun1284, mun1311, 
			mun1316, mun1362, mun1366, mun1371, mun1379, mun1391, mun1398, mun1411, 
			mun1426, mun1475, mun1480, mun1481, mun1483, mun1488, mun1508, mun1510, 
			mun1553, mun1554, mun1555, mun1589, mun1620, mun1624, mun1629, mun1664, 
			mun1665, mun1673, mun1696, mun1701, mun1743, mun1752, mun1755, mun1771, 
			mun168, mun182, mun189, mun210, mun213, mun228, mun245, mun257, 
			mun1772, mun1785, mun1794, mun1797, mun1808, mun1810, mun1815, mun1822, 
			mun1840, mun1841, mun1845, mun1848, mun1901, mun1920, mun1935, mun1936, 
			mun1962, mun1981, mun1983, mun1989, mun1996, mun1999, mun2003, mun2018, 
			mun2022, mun2023, mun2029, mun2065, mun2081, mun2087, mun2104, mun2131, 
			mun2159, mun2162, mun2178, mun2182, mun2186, mun2189, mun2198, mun2239, 
			mun2244, mun2257, mun2272, mun2276, mun2311, mun2323, mun2341, mun2344, 
			mun2366, mun2369, mun2427, mun2454, mun2455, mun2456, mun2457, mun2466, 
			mun2476, mun2490, mun2498, mun2511, mun2518, mun2526, mun2530, mun2538, 
			mun2543, mun2552, mun2578, mun2603, mun2640, mun2649, mun2659, mun2667, 
			mun266, mun286, mun334, mun336, mun338, mun352, mun358, mun383, 
			mun2738, mun2744, mun2745, mun2767, mun2771, mun2780, mun2790, mun2791, 
			mun2793, mun2814, mun2817, mun2819, mun2874, mun2878, mun2887, mun2888, 
			mun2889, mun2891, mun2894, mun2899, mun2943, mun2950, mun2951, mun2960, 
			mun2962, mun2964, mun2965, mun2968, mun2970, mun2974, mun2977, mun2984, 
			mun2999, mun3009, mun3015, mun3026, mun3037, mun3045, mun3080, mun3094, 
			mun3101, mun3173, mun3177, mun3215, mun3279, mun3285, mun3289, mun3293, 
			mun3307, mun3315, mun3317, mun3319, mun3337, mun3339, mun3349, mun3361, 
			mun3370, mun3374, mun3377, mun3405, mun3464, mun3475, mun3485, mun3508, 
			mun3528, mun3534, mun3546, mun3551, mun3574, mun3585, mun3586, mun3591, 
			mun3595, mun3641, mun3642, mun3659, mun3671, mun3679, mun3749, mun3750, 
			mun3751, mun3776, mun3798, mun3800, mun3803, mun3806, mun3827, mun3845, 
			mun3859, mun3860, mun3869, mun3874, mun3905, mun3908, mun3932, mun3945, 
			mun3946, mun3968, mun3973, mun3991, mun3999, mun4009, mun4038, mun4047, 
			mun4055, mun4057, mun4060, mun4062, mun4064, mun4072, mun4077, mun4083, 
			mun408, mun411, mun416, mun418, mun471, mun483, mun498, mun521, 
			mun4096, mun4098, mun4099, mun4104, mun4105, mun4122, mun4127, mun4128, 
			mun4164, mun4168, mun4183, mun4185, mun4186, mun4188, mun4189, mun4226, 
			mun4259, mun4264, mun4269, mun4276, mun4292, mun4308, mun4322, mun4324, 
			mun4342, mun4355, mun4369, mun4388, mun4397, mun4401, mun4403, mun4408, 
			mun4411, mun4433, mun4441, mun4443, mun4477, mun4481, mun4503, mun4537, 
			mun4547, mun4558, mun4563, mun4575, mun4603, mun4676, mun4703, mun4707, 
			mun4724, mun4729, mun4734, mun4735, mun4736, mun4740, mun4750, mun4794, 
			mun4818, mun4825, mun4840, mun4862, mun4863, mun4864, mun4883, mun4909, 
			mun4926, mun4932, mun4942, mun4975, mun5014, mun5024, mun5026, mun5059, 
			mun5095, mun5129, mun5131, mun5146, mun5153, mun5185, mun5191, mun5210, 
			mun5215, mun5216, mun5223, mun5228, mun5249, mun5251, mun5274, mun5311, 
			mun5313, mun5323, mun5336, mun5354, mun5369, mun5373, mun5380, mun5383, 
			mun536, mun570, mun574, mun629, mun631, mun634, mun638, mun641, 
			mun5458, mun5460, mun5470, mun5519, mun5537, mun5547, mun5552, 
			mun658, mun684, mun701, mun704, mun731, mun744, mun749, mun873, 
			mun874, mun876, mun910, mun924, mun925, mun926, mun941, mun944, 
			mun945, mun963, mun967, mun975, mun978, mun980, mun1018, mun1025));

	}
	
	private void instanciaMunUf19(UF uf19) {
		Municipio mun243 = new Municipio(null, "Angra dos Reis", uf19);
		Municipio mun276 = new Municipio(null, "Aperibé", uf19);
		Municipio mun350 = new Municipio(null, "Araruama", uf19);
		Municipio mun366 = new Municipio(null, "Areal", uf19);
		Municipio mun385 = new Municipio(null, "Armação dos Búzios", uf19);
		Municipio mun391 = new Municipio(null, "Arraial do Cabo", uf19);
		Municipio mun524 = new Municipio(null, "Barra do Piraí", uf19);
		Municipio mun533 = new Municipio(null, "Barra Mansa", uf19);
		Municipio mun586 = new Municipio(null, "Belford Roxo", uf19);
		Municipio mun672 = new Municipio(null, "Bom Jardim", uf19);
		Municipio mun681 = new Municipio(null, "Bom Jesus do Itabapoana", uf19);
		Municipio mun827 = new Municipio(null, "Cabo Frio", uf19);
		Municipio mun852 = new Municipio(null, "Cachoeiras de Macacu", uf19);
		Municipio mun928 = new Municipio(null, "Cambuci", uf19);
		Municipio mun991 = new Municipio(null, "Campos dos Goytacazes", uf19);
		Municipio mun1041 = new Municipio(null, "Cantagalo", uf19);
		Municipio mun1096 = new Municipio(null, "Carapebus", uf19);
		Municipio mun1107 = new Municipio(null, "Cardoso Moreira", uf19);
		Municipio mun1134 = new Municipio(null, "Carmo", uf19);
		Municipio mun1164 = new Municipio(null, "Casimiro de Abreu", uf19);
		Municipio mun1321 = new Municipio(null, "Comendador Levy Gasparian", uf19);
		Municipio mun1331 = new Municipio(null, "Conceição de Macabu", uf19);
		Municipio mun1380 = new Municipio(null, "Cordeiro", uf19);
		Municipio mun1633 = new Municipio(null, "Duas Barras", uf19);
		Municipio mun1638 = new Municipio(null, "Duque de Caxias", uf19);
		Municipio mun1669 = new Municipio(null, "Engenheiro Paulo de Frontin", uf19);
		Municipio mun1995 = new Municipio(null, "Guapimirim", uf19);
		Municipio mun2155 = new Municipio(null, "Iguaba Grande", uf19);
		Municipio mun2295 = new Municipio(null, "Itaboraí", uf19);
		Municipio mun2310 = new Municipio(null, "Itaguaí", uf19);
		Municipio mun2334 = new Municipio(null, "Italva", uf19);
		Municipio mun2356 = new Municipio(null, "Itaocara", uf19);
		Municipio mun2370 = new Municipio(null, "Itaperuna", uf19);
		Municipio mun2413 = new Municipio(null, "Itatiaia", uf19);
		Municipio mun2524 = new Municipio(null, "Japeri", uf19);
		Municipio mun2719 = new Municipio(null, "Laje do Muriaé", uf19);
		Municipio mun2826 = new Municipio(null, "Macaé", uf19);
		Municipio mun2846 = new Municipio(null, "Macuco", uf19);
		Municipio mun2859 = new Municipio(null, "Magé", uf19);
		Municipio mun2893 = new Municipio(null, "Mangaratiba", uf19);
		Municipio mun2958 = new Municipio(null, "Maricá", uf19);
		Municipio mun3043 = new Municipio(null, "Mendes", uf19);
		Municipio mun3051 = new Municipio(null, "Mesquita", uf19);
		Municipio mun3057 = new Municipio(null, "Miguel Pereira", uf19);
		Municipio mun3078 = new Municipio(null, "Miracema", uf19);
		Municipio mun3242 = new Municipio(null, "Natividade", uf19);
		Municipio mun3263 = new Municipio(null, "Nilópolis", uf19);
		Municipio mun3270 = new Municipio(null, "Niterói", uf19);
		Municipio mun3322 = new Municipio(null, "Nova Friburgo", uf19);
		Municipio mun3330 = new Municipio(null, "Nova Iguaçu", uf19);
		Municipio mun3563 = new Municipio(null, "Paracambi", uf19);
		Municipio mun3570 = new Municipio(null, "Paraíba do Sul", uf19);
		Municipio mun3600 = new Municipio(null, "Parati", uf19);
		Municipio mun3650 = new Municipio(null, "Paty do Alferes", uf19);
		Municipio mun3760 = new Municipio(null, "Petrópolis", uf19);
		Municipio mun3808 = new Municipio(null, "Pinheiral", uf19);
		Municipio mun3828 = new Municipio(null, "Piraí", uf19);
		Municipio mun3931 = new Municipio(null, "Porciúncula", uf19);
		Municipio mun3966 = new Municipio(null, "Porto Real", uf19);
		Municipio mun4059 = new Municipio(null, "Quatis", uf19);
		Municipio mun4068 = new Municipio(null, "Queimados", uf19);
		Municipio mun4082 = new Municipio(null, "Quissamã", uf19);
		Municipio mun4125 = new Municipio(null, "Resende", uf19);
		Municipio mun4187 = new Municipio(null, "Rio Bonito", uf19);
		Municipio mun4194 = new Municipio(null, "Rio Claro", uf19);
		Municipio mun4199 = new Municipio(null, "Rio das Flores", uf19);
		Municipio mun4200 = new Municipio(null, "Rio das Ostras", uf19);
		Municipio mun4203 = new Municipio(null, "Rio de Janeiro", uf19);
		Municipio mun4438 = new Municipio(null, "Santa Maria Madalena", uf19);
		Municipio mun4542 = new Municipio(null, "Santo Antônio de Pádua", uf19);
		Municipio mun4634 = new Municipio(null, "São Fidélis", uf19);
		Municipio mun4638 = new Municipio(null, "São Francisco de Itabapoana", uf19);
		Municipio mun4674 = new Municipio(null, "São Gonçalo", uf19);
		Municipio mun4683 = new Municipio(null, "São João da Barra", uf19);
		Municipio mun4698 = new Municipio(null, "São João de Meriti", uf19);
		Municipio mun4757 = new Municipio(null, "São José de Ubá", uf19);
		Municipio mun4788 = new Municipio(null, "São José do Vale do Rio Pret", uf19);
		Municipio mun4855 = new Municipio(null, "São Pedro da Aldeia", uf19);
		Municipio mun4889 = new Municipio(null, "São Sebastião do Alto", uf19);
		Municipio mun4929 = new Municipio(null, "Sapucaia", uf19);
		Municipio mun4931 = new Municipio(null, "Saquarema", uf19);
		Municipio mun4988 = new Municipio(null, "Seropédica", uf19);
		Municipio mun5042 = new Municipio(null, "Silva Jardim", uf19);
		Municipio mun5098 = new Municipio(null, "Sumidouro", uf19);
		Municipio mun5138 = new Municipio(null, "Tanguá", uf19);
		Municipio mun5206 = new Municipio(null, "Teresópolis", uf19);
		Municipio mun5268 = new Municipio(null, "Trajano de Morais", uf19);
		Municipio mun5288 = new Municipio(null, "Três Rios", uf19);
		Municipio mun5416 = new Municipio(null, "Valença", uf19);
		Municipio mun5439 = new Municipio(null, "Varre-Sai", uf19);
		Municipio mun5453 = new Municipio(null, "Vassouras", uf19);
		Municipio mun5539 = new Municipio(null, "Volta Redonda", uf19);

		municipioRepository.saveAll(Arrays.asList(mun1096, mun1107, mun1134, mun1164, mun1321, mun1331, mun1380, mun1633, 
			mun1638, mun1669, mun1995, mun2155, mun2295, mun2310, mun2334, mun2356, 
			mun2370, mun2413, mun2524, mun2719, mun2826, mun2846, mun2859, mun2893, 
			mun243, mun276, mun350, mun366, mun385, mun391, mun524, mun533, 
			mun2958, mun3043, mun3051, mun3057, mun3078, mun3242, mun3263, mun3270, 
			mun3322, mun3330, mun3563, mun3570, mun3600, mun3650, mun3760, mun3808, 
			mun3828, mun3931, mun3966, mun4059, mun4068, mun4082, mun4125, mun4187, 
			mun4194, mun4199, mun4200, mun4203, mun4438, mun4542, mun4634, mun4638, 
			mun4674, mun4683, mun4698, mun4757, mun4788, mun4855, mun4889, mun4929, 
			mun4931, mun4988, mun5042, mun5098, mun5138, mun5206, mun5268, mun5288, 
			mun5416, mun5439, mun5453, mun5539, 
			mun586, mun672, mun681, mun827, mun852, mun928, mun991, mun1041));

	}
	
	private void instanciaMunUf20(UF uf20) {
		Municipio mun23 = new Municipio(null, "Acari", uf20);
		Municipio mun30 = new Municipio(null, "Açu", uf20);
		Municipio mun38 = new Municipio(null, "Afonso Bezerra", uf20);
		Municipio mun60 = new Municipio(null, "Água Nova", uf20);
		Municipio mun109 = new Municipio(null, "Alexandria", uf20);
		Municipio mun124 = new Municipio(null, "Almino Afonso", uf20);
		Municipio mun151 = new Municipio(null, "Alto do Rodrigues", uf20);
		Municipio mun242 = new Municipio(null, "Angicos", uf20);
		Municipio mun265 = new Municipio(null, "Antônio Martins", uf20);
		Municipio mun282 = new Municipio(null, "Apodi", uf20);
		Municipio mun368 = new Municipio(null, "Areia Branca", uf20);
		Municipio mun377 = new Municipio(null, "Arês", uf20);
		Municipio mun428 = new Municipio(null, "Augusto Severo", uf20);
		Municipio mun456 = new Municipio(null, "Baía Formosa", uf20);
		Municipio mun495 = new Municipio(null, "Baraúna", uf20);
		Municipio mun501 = new Municipio(null, "Barcelona", uf20);
		Municipio mun604 = new Municipio(null, "Bento Fernandes", uf20);
		Municipio mun660 = new Municipio(null, "Bodó", uf20);
		Municipio mun690 = new Municipio(null, "Bom Jesus", uf20);
		Municipio mun765 = new Municipio(null, "Brejinho", uf20);
		Municipio mun882 = new Municipio(null, "Caiçara do Norte", uf20);
		Municipio mun883 = new Municipio(null, "Caiçara do Rio do Vento", uf20);
		Municipio mun886 = new Municipio(null, "Caicó", uf20);
		Municipio mun984 = new Municipio(null, "Campo Redondo", uf20);
		Municipio mun1028 = new Municipio(null, "Canguaretama", uf20);
		Municipio mun1102 = new Municipio(null, "Caraúbas", uf20);
		Municipio mun1139 = new Municipio(null, "Carnaúba dos Dantas", uf20);
		Municipio mun1140 = new Municipio(null, "Carnaubais", uf20);
		Municipio mun1207 = new Municipio(null, "Ceará-Mirim", uf20);
		Municipio mun1231 = new Municipio(null, "Cerro Corá", uf20);
		Municipio mun1399 = new Municipio(null, "Coronel Ezequiel", uf20);
		Municipio mun1402 = new Municipio(null, "Coronel João Pessoa", uf20);
		Municipio mun1486 = new Municipio(null, "Cruzeta", uf20);
		Municipio mun1511 = new Municipio(null, "Currais Novos", uf20);
		Municipio mun1628 = new Municipio(null, "Doutor Severiano", uf20);
		Municipio mun1661 = new Municipio(null, "Encanto", uf20);
		Municipio mun1680 = new Municipio(null, "Equador", uf20);
		Municipio mun1707 = new Municipio(null, "Espírito Santo", uf20);
		Municipio mun1734 = new Municipio(null, "Extremoz", uf20);
		Municipio mun1765 = new Municipio(null, "Felipe Guerra", uf20);
		Municipio mun1776 = new Municipio(null, "Fernando Pedroza", uf20);
		Municipio mun1798 = new Municipio(null, "Florânia", uf20);
		Municipio mun1849 = new Municipio(null, "Francisco Dantas", uf20);
		Municipio mun1871 = new Municipio(null, "Frutuoso Gomes", uf20);
		Municipio mun1878 = new Municipio(null, "Galinhos", uf20);
		Municipio mun1929 = new Municipio(null, "Goianinha", uf20);
		Municipio mun1945 = new Municipio(null, "Governador Dix-Sept Rosado", uf20);
		Municipio mun1972 = new Municipio(null, "Grossos", uf20);
		Municipio mun1988 = new Municipio(null, "Guamaré", uf20);
		Municipio mun2137 = new Municipio(null, "Ielmo Marinho", uf20);
		Municipio mun2221 = new Municipio(null, "Ipanguaçu", uf20);
		Municipio mun2251 = new Municipio(null, "Ipueira", uf20);
		Municipio mun2326 = new Municipio(null, "Itajá", uf20);
		Municipio mun2422 = new Municipio(null, "Itaú", uf20);
		Municipio mun2470 = new Municipio(null, "Jaçanã", uf20);
		Municipio mun2513 = new Municipio(null, "Jandaíra", uf20);
		Municipio mun2516 = new Municipio(null, "Janduís", uf20);
		Municipio mun2520 = new Municipio(null, "Januário Cicco", uf20);
		Municipio mun2525 = new Municipio(null, "Japi", uf20);
		Municipio mun2539 = new Municipio(null, "Jardim de Angicos", uf20);
		Municipio mun2540 = new Municipio(null, "Jardim de Piranhas", uf20);
		Municipio mun2542 = new Municipio(null, "Jardim do Seridó", uf20);
		Municipio mun2589 = new Municipio(null, "João Câmara", uf20);
		Municipio mun2591 = new Municipio(null, "João Dias", uf20);
		Municipio mun2611 = new Municipio(null, "José da Penha", uf20);
		Municipio mun2629 = new Municipio(null, "Jucurutu", uf20);
		Municipio mun2639 = new Municipio(null, "Jundiá", uf20);
		Municipio mun2682 = new Municipio(null, "Lagoa d'Anta", uf20);
		Municipio mun2687 = new Municipio(null, "Lagoa de Pedras", uf20);
		Municipio mun2689 = new Municipio(null, "Lagoa de Velhos", uf20);
		Municipio mun2706 = new Municipio(null, "Lagoa Nova", uf20);
		Municipio mun2708 = new Municipio(null, "Lagoa Salgada", uf20);
		Municipio mun2730 = new Municipio(null, "Lajes Pintadas", uf20);
		Municipio mun2731 = new Municipio(null, "Lajes", uf20);
		Municipio mun2805 = new Municipio(null, "Lucrécia", uf20);
		Municipio mun2810 = new Municipio(null, "Luís Gomes", uf20);
		Municipio mun2827 = new Municipio(null, "Macaíba", uf20);
		Municipio mun2835 = new Municipio(null, "Macau", uf20);
		Municipio mun2867 = new Municipio(null, "Major Sales", uf20);
		Municipio mun2938 = new Municipio(null, "Marcelino Vieira", uf20);
		Municipio mun2982 = new Municipio(null, "Martins", uf20);
		Municipio mun3032 = new Municipio(null, "Maxaranguape", uf20);
		Municipio mun3052 = new Municipio(null, "Messias Targino", uf20);
		Municipio mun3129 = new Municipio(null, "Montanhas", uf20);
		Municipio mun3138 = new Municipio(null, "Monte Alegre", uf20);
		Municipio mun3149 = new Municipio(null, "Monte das Gameleiras", uf20);
		Municipio mun3196 = new Municipio(null, "Mossoró", uf20);
		Municipio mun3238 = new Municipio(null, "Natal", uf20);
		Municipio mun3269 = new Municipio(null, "Nísia Floresta", uf20);
		Municipio mun3311 = new Municipio(null, "Nova Cruz", uf20);
		Municipio mun3438 = new Municipio(null, "Olho-d'Água do Borges", uf20);
		Municipio mun3478 = new Municipio(null, "Ouro Branco", uf20);
		Municipio mun3583 = new Municipio(null, "Paraná", uf20);
		Municipio mun3602 = new Municipio(null, "Paraú", uf20);
		Municipio mun3605 = new Municipio(null, "Parazinho", uf20);
		Municipio mun3609 = new Municipio(null, "Parelhas", uf20);
		Municipio mun3619 = new Municipio(null, "Parnamirim", uf20);
		Municipio mun3622 = new Municipio(null, "Passa e Fica", uf20);
		Municipio mun3630 = new Municipio(null, "Passagem", uf20);
		Municipio mun3649 = new Municipio(null, "Patu", uf20);
		Municipio mun3655 = new Municipio(null, "Pau dos Ferros", uf20);
		Municipio mun3691 = new Municipio(null, "Pedra Grande", uf20);
		Municipio mun3695 = new Municipio(null, "Pedra Preta", uf20);
		Municipio mun3712 = new Municipio(null, "Pedro Avelino", uf20);
		Municipio mun3723 = new Municipio(null, "Pedro Velho", uf20);
		Municipio mun3732 = new Municipio(null, "Pendências", uf20);
		Municipio mun3783 = new Municipio(null, "Pilões", uf20);
		Municipio mun3884 = new Municipio(null, "Poço Branco", uf20);
		Municipio mun3933 = new Municipio(null, "Portalegre", uf20);
		Municipio mun3952 = new Municipio(null, "Porto do Mangue", uf20);
		Municipio mun4019 = new Municipio(null, "Presidente Juscelino", uf20);
		Municipio mun4049 = new Municipio(null, "Pureza", uf20);
		Municipio mun4092 = new Municipio(null, "Rafael Fernandes", uf20);
		Municipio mun4093 = new Municipio(null, "Rafael Godeiro", uf20);
		Municipio mun4143 = new Municipio(null, "Riacho da Cruz", uf20);
		Municipio mun4145 = new Municipio(null, "Riacho de Santana", uf20);
		Municipio mun4151 = new Municipio(null, "Riachuelo", uf20);
		Municipio mun4206 = new Municipio(null, "Rio do Fogo", uf20);
		Municipio mun4256 = new Municipio(null, "Rodolfo Fernandes", uf20);
		Municipio mun4289 = new Municipio(null, "Ruy Barbosa", uf20);
		Municipio mun4381 = new Municipio(null, "Santa Cruz", uf20);
		Municipio mun4439 = new Municipio(null, "Santa Maria", uf20);
		Municipio mun4508 = new Municipio(null, "Santana do Matos", uf20);
		Municipio mun4514 = new Municipio(null, "Santana do Seridó", uf20);
		Municipio mun4567 = new Municipio(null, "Santo Antônio", uf20);
		Municipio mun4584 = new Municipio(null, "São Bento do Norte", uf20);
		Municipio mun4588 = new Municipio(null, "São Bento do Trairí", uf20);
		Municipio mun4633 = new Municipio(null, "São Fernando", uf20);
		Municipio mun4647 = new Municipio(null, "São Francisco do Oeste", uf20);
		Municipio mun4665 = new Municipio(null, "São Gonçalo do Amarante", uf20);
		Municipio mun4720 = new Municipio(null, "São João do Sabugi", uf20);
		Municipio mun4753 = new Municipio(null, "São José de Mipibu", uf20);
		Municipio mun4764 = new Municipio(null, "São José do Campestre", uf20);
		Municipio mun4786 = new Municipio(null, "São José do Seridó", uf20);
		Municipio mun4837 = new Municipio(null, "São Miguel do Gostoso", uf20);
		Municipio mun4847 = new Municipio(null, "São Miguel", uf20);
		Municipio mun4852 = new Municipio(null, "São Paulo do Potengi", uf20);
		Municipio mun4871 = new Municipio(null, "São Pedro", uf20);
		Municipio mun4873 = new Municipio(null, "São Rafael", uf20);
		Municipio mun4910 = new Municipio(null, "São Tomé", uf20);
		Municipio mun4920 = new Municipio(null, "São Vicente", uf20);
		Municipio mun4963 = new Municipio(null, "Senador Elói de Souza", uf20);
		Municipio mun4965 = new Municipio(null, "Senador Georgino Avelino", uf20);
		Municipio mun4995 = new Municipio(null, "Serra de São Bento", uf20);
		Municipio mun4996 = new Municipio(null, "Serra do Mel", uf20);
		Municipio mun5003 = new Municipio(null, "Serra Negra do Norte", uf20);
		Municipio mun5018 = new Municipio(null, "Serrinha dos Pintos", uf20);
		Municipio mun5019 = new Municipio(null, "Serrinha", uf20);
		Municipio mun5037 = new Municipio(null, "Severiano Melo", uf20);
		Municipio mun5067 = new Municipio(null, "Sítio Novo", uf20);
		Municipio mun5111 = new Municipio(null, "Taboleiro Grande", uf20);
		Municipio mun5125 = new Municipio(null, "Taipu", uf20);
		Municipio mun5136 = new Municipio(null, "Tangará", uf20);
		Municipio mun5193 = new Municipio(null, "Tenente Ananias", uf20);
		Municipio mun5194 = new Municipio(null, "Tenente Laurentino Cruz", uf20);
		Municipio mun5224 = new Municipio(null, "Tibau do Sul", uf20);
		Municipio mun5225 = new Municipio(null, "Tibau", uf20);
		Municipio mun5230 = new Municipio(null, "Timbaúba dos Batistas", uf20);
		Municipio mun5261 = new Municipio(null, "Touros", uf20);
		Municipio mun5295 = new Municipio(null, "Triunfo Potiguar", uf20);
		Municipio mun5363 = new Municipio(null, "Umarizal", uf20);
		Municipio mun5382 = new Municipio(null, "Upanema", uf20);
		Municipio mun5450 = new Municipio(null, "Várzea", uf20);
		Municipio mun5457 = new Municipio(null, "Venha-Ver", uf20);
		Municipio mun5461 = new Municipio(null, "Vera Cruz", uf20);
		Municipio mun5491 = new Municipio(null, "Viçosa", uf20);
		Municipio mun5500 = new Municipio(null, "Vila Flor", uf20);

		municipioRepository.saveAll(Arrays.asList(mun1028, mun1102, mun1139, mun1140, mun1207, mun1231, mun1399, mun1402, 
			mun1486, mun1511, mun1628, mun1661, mun1680, mun1707, mun1734, mun1765, 
			mun1776, mun1798, mun1849, mun1871, mun1878, mun1929, mun1945, mun1972, 
			mun1988, mun2137, mun2221, mun2251, mun2326, mun2422, mun2470, mun2513, 
			mun23, mun30, mun38, mun60, mun109, mun124, mun151, mun242, 
			mun2516, mun2520, mun2525, mun2539, mun2540, mun2542, mun2589, mun2591, 
			mun2611, mun2629, mun2639, mun2682, mun2687, mun2689, mun2706, mun2708, 
			mun265, mun282, mun368, mun377, mun428, mun456, mun495, mun501, 
			mun2730, mun2731, mun2805, mun2810, mun2827, mun2835, mun2867, mun2938, 
			mun2982, mun3032, mun3052, mun3129, mun3138, mun3149, mun3196, mun3238, 
			mun3269, mun3311, mun3438, mun3478, mun3583, mun3602, mun3605, mun3609, 
			mun3619, mun3622, mun3630, mun3649, mun3655, mun3691, mun3695, mun3712, 
			mun3723, mun3732, mun3783, mun3884, mun3933, mun3952, mun4019, mun4049, 
			mun4092, mun4093, mun4143, mun4145, mun4151, mun4206, mun4256, mun4289, 
			mun4381, mun4439, mun4508, mun4514, mun4567, mun4584, mun4588, mun4633, 
			mun4647, mun4665, mun4720, mun4753, mun4764, mun4786, mun4837, mun4847, 
			mun4852, mun4871, mun4873, mun4910, mun4920, mun4963, mun4965, mun4995, 
			mun4996, mun5003, mun5018, mun5019, mun5037, mun5067, mun5111, mun5125, 
			mun5136, mun5193, mun5194, mun5224, mun5225, mun5230, mun5261, mun5295, 
			mun5363, mun5382, mun5450, mun5457, mun5461, mun5491, mun5500, 
			mun604, mun660, mun690, mun765, mun882, mun883, mun886, mun984));

	}
	
	private void instanciaMunUf21(UF uf21) {
		Municipio mun131 = new Municipio(null, "Alta Floresta d'Oeste", uf21);
		Municipio mun143 = new Municipio(null, "Alto Alegre dos Parecis", uf21);
		Municipio mun160 = new Municipio(null, "Alto Paraíso", uf21);
		Municipio mun178 = new Municipio(null, "Alvorada d'Oeste", uf21);
		Municipio mun382 = new Municipio(null, "Ariquemes", uf21);
		Municipio mun811 = new Municipio(null, "Buritis", uf21);
		Municipio mun825 = new Municipio(null, "Cabixi", uf21);
		Municipio mun835 = new Municipio(null, "Cacaulândia", uf21);
		Municipio mun862 = new Municipio(null, "Cacoal", uf21);
		Municipio mun981 = new Municipio(null, "Campo Novo de Rondônia", uf21);
		Municipio mun1013 = new Municipio(null, "Candeias do Jamari", uf21);
		Municipio mun1172 = new Municipio(null, "Castanheiras", uf21);
		Municipio mun1224 = new Municipio(null, "Cerejeiras", uf21);
		Municipio mun1268 = new Municipio(null, "Chupinguaia", uf21);
		Municipio mun1315 = new Municipio(null, "Colorado do Oeste", uf21);
		Municipio mun1428 = new Municipio(null, "Corumbiara", uf21);
		Municipio mun1433 = new Municipio(null, "Costa Marques", uf21);
		Municipio mun1495 = new Municipio(null, "Cujubim", uf21);
		Municipio mun1702 = new Municipio(null, "Espigão d'Oeste", uf21);
		Municipio mun1948 = new Municipio(null, "Governador Jorge Teixeira", uf21);
		Municipio mun1986 = new Municipio(null, "Guajará-Mirim", uf21);
		Municipio mun2396 = new Municipio(null, "Itapuã do Oeste", uf21);
		Municipio mun2550 = new Municipio(null, "Jaru", uf21);
		Municipio mun2581 = new Municipio(null, "Ji-Paraná", uf21);
		Municipio mun2841 = new Municipio(null, "Machadinho d'Oeste", uf21);
		Municipio mun3073 = new Municipio(null, "Ministro Andreazza", uf21);
		Municipio mun3091 = new Municipio(null, "Mirante da Serra", uf21);
		Municipio mun3154 = new Municipio(null, "Monte Negro", uf21);
		Municipio mun3299 = new Municipio(null, "Nova Brasilândia d'Oeste", uf21);
		Municipio mun3341 = new Municipio(null, "Nova Mamoré", uf21);
		Municipio mun3382 = new Municipio(null, "Nova União", uf21);
		Municipio mun3400 = new Municipio(null, "Novo Horizonte do Oeste", uf21);
		Municipio mun3480 = new Municipio(null, "Ouro Preto do Oeste", uf21);
		Municipio mun3608 = new Municipio(null, "Parecis", uf21);
		Municipio mun3785 = new Municipio(null, "Pimenta Bueno", uf21);
		Municipio mun3787 = new Municipio(null, "Pimenteiras do Oeste", uf21);
		Municipio mun3971 = new Municipio(null, "Porto Velho", uf21);
		Municipio mun4025 = new Municipio(null, "Presidente Médici", uf21);
		Municipio mun4033 = new Municipio(null, "Primavera de Rondônia", uf21);
		Municipio mun4196 = new Municipio(null, "Rio Crespo", uf21);
		Municipio mun4261 = new Municipio(null, "Rolim de Moura", uf21);
		Municipio mun4414 = new Municipio(null, "Santa Luzia d'Oeste", uf21);
		Municipio mun4623 = new Municipio(null, "São Felipe d'Oeste", uf21);
		Municipio mun4645 = new Municipio(null, "São Francisco do Guaporé", uf21);
		Municipio mun4839 = new Municipio(null, "São Miguel do Guaporé", uf21);
		Municipio mun4985 = new Municipio(null, "Seringueiras", uf21);
		Municipio mun5188 = new Municipio(null, "Teixeirópolis", uf21);
		Municipio mun5221 = new Municipio(null, "Theobroma", uf21);
		Municipio mun5402 = new Municipio(null, "Urupá", uf21);
		Municipio mun5410 = new Municipio(null, "Vale do Anari", uf21);
		Municipio mun5411 = new Municipio(null, "Vale do Paraíso", uf21);
		Municipio mun5512 = new Municipio(null, "Vilhena", uf21);

		municipioRepository.saveAll(Arrays.asList(mun131, mun143, mun160, mun178, mun382, mun811, mun825, mun835, 
			mun1433, mun1495, mun1702, mun1948, mun1986, mun2396, mun2550, mun2581, 
			mun2841, mun3073, mun3091, mun3154, mun3299, mun3341, mun3382, mun3400, 
			mun3480, mun3608, mun3785, mun3787, mun3971, mun4025, mun4033, mun4196, 
			mun4261, mun4414, mun4623, mun4645, mun4839, mun4985, mun5188, mun5221, 
			mun5402, mun5410, mun5411, mun5512, 
			mun862, mun981, mun1013, mun1172, mun1224, mun1268, mun1315, mun1428));

	}
	
	private void instanciaMunUf22(UF uf22) {
		Municipio mun144 = new Municipio(null, "Alto Alegre", uf22);
		Municipio mun185 = new Municipio(null, "Amajari", uf22);
		Municipio mun651 = new Municipio(null, "Boa Vista", uf22);
		Municipio mun708 = new Municipio(null, "Bonfim", uf22);
		Municipio mun1038 = new Municipio(null, "Cantá", uf22);
		Municipio mun1086 = new Municipio(null, "Caracaraí", uf22);
		Municipio mun1145 = new Municipio(null, "Caroebe", uf22);
		Municipio mun2258 = new Municipio(null, "Iracema", uf22);
		Municipio mun3201 = new Municipio(null, "Mucajaí", uf22);
		Municipio mun3274 = new Municipio(null, "Normandia", uf22);
		Municipio mun3495 = new Municipio(null, "Pacaraima", uf22);
		Municipio mun4272 = new Municipio(null, "Rorainópolis", uf22);
		Municipio mun4682 = new Municipio(null, "São João da Baliza", uf22);
		Municipio mun4816 = new Municipio(null, "São Luiz", uf22);
		Municipio mun5358 = new Municipio(null, "Uiramutã", uf22);

		municipioRepository.saveAll(Arrays.asList(mun144, mun185, mun651, mun708, mun1038, mun1086, mun1145, mun2258, 
				mun3201, mun3274, mun3495, mun4272, mun4682, mun4816, mun5358));

	}
	
	private void instanciaMunUf23(UF uf23) {
		Municipio mun25 = new Municipio(null, "Aceguá", uf23);
		Municipio mun62 = new Municipio(null, "Água Santa", uf23);
		Municipio mun76 = new Municipio(null, "Agudo", uf23);
		Municipio mun86 = new Municipio(null, "Ajuricaba", uf23);
		Municipio mun102 = new Municipio(null, "Alecrim", uf23);
		Municipio mun105 = new Municipio(null, "Alegrete", uf23);
		Municipio mun106 = new Municipio(null, "Alegria", uf23);
		Municipio mun125 = new Municipio(null, "Almirante Tamandaré do Sul", uf23);
		Municipio mun129 = new Municipio(null, "Alpestre", uf23);
		Municipio mun145 = new Municipio(null, "Alto Alegre", uf23);
		Municipio mun152 = new Municipio(null, "Alto Feliz", uf23);
		Municipio mun183 = new Municipio(null, "Alvorada", uf23);
		Municipio mun191 = new Municipio(null, "Amaral Ferrador", uf23);
		Municipio mun203 = new Municipio(null, "Ametista do Sul", uf23);
		Municipio mun232 = new Municipio(null, "André da Rocha", uf23);
		Municipio mun254 = new Municipio(null, "Anta Gorda", uf23);
		Municipio mun268 = new Municipio(null, "Antônio Prado", uf23);
		Municipio mun325 = new Municipio(null, "Arambaré", uf23);
		Municipio mun347 = new Municipio(null, "Araricá", uf23);
		Municipio mun354 = new Municipio(null, "Aratiba", uf23);
		Municipio mun394 = new Municipio(null, "Arroio do Meio", uf23);
		Municipio mun395 = new Municipio(null, "Arroio do Padre", uf23);
		Municipio mun396 = new Municipio(null, "Arroio do Sal", uf23);
		Municipio mun397 = new Municipio(null, "Arroio do Tigre", uf23);
		Municipio mun398 = new Municipio(null, "Arroio dos Ratos", uf23);
		Municipio mun399 = new Municipio(null, "Arroio Grande", uf23);
		Municipio mun405 = new Municipio(null, "Arvorezinha", uf23);
		Municipio mun427 = new Municipio(null, "Augusto Pestana", uf23);
		Municipio mun429 = new Municipio(null, "Áurea", uf23);
		Municipio mun453 = new Municipio(null, "Bagé", uf23);
		Municipio mun470 = new Municipio(null, "Balneário Pinhal", uf23);
		Municipio mun488 = new Municipio(null, "Barão de Cotegipe", uf23);
		Municipio mun492 = new Municipio(null, "Barão do Triunfo", uf23);
		Municipio mun493 = new Municipio(null, "Barão", uf23);
		Municipio mun520 = new Municipio(null, "Barra do Guarita", uf23);
		Municipio mun525 = new Municipio(null, "Barra do Quaraí", uf23);
		Municipio mun526 = new Municipio(null, "Barra do Ribeiro", uf23);
		Municipio mun527 = new Municipio(null, "Barra do Rio Azul", uf23);
		Municipio mun531 = new Municipio(null, "Barra Funda", uf23);
		Municipio mun537 = new Municipio(null, "Barracão", uf23);
		Municipio mun555 = new Municipio(null, "Barros Cassal", uf23);
		Municipio mun601 = new Municipio(null, "Benjamin Constant do Sul", uf23);
		Municipio mun605 = new Municipio(null, "Bento Gonçalves", uf23);
		Municipio mun642 = new Municipio(null, "Boa Vista das Missões", uf23);
		Municipio mun643 = new Municipio(null, "Boa Vista do Buricá", uf23);
		Municipio mun644 = new Municipio(null, "Boa Vista do Cadeado", uf23);
		Municipio mun646 = new Municipio(null, "Boa Vista do Incra", uf23);
		Municipio mun648 = new Municipio(null, "Boa Vista do Sul", uf23);
		Municipio mun691 = new Municipio(null, "Bom Jesus", uf23);
		Municipio mun695 = new Municipio(null, "Bom Princípio", uf23);
		Municipio mun696 = new Municipio(null, "Bom Progresso", uf23);
		Municipio mun698 = new Municipio(null, "Bom Retiro do Sul", uf23);
		Municipio mun719 = new Municipio(null, "Boqueirão do Leão", uf23);
		Municipio mun732 = new Municipio(null, "Bossoroca", uf23);
		Municipio mun738 = new Municipio(null, "Bozano", uf23);
		Municipio mun741 = new Municipio(null, "Braga", uf23);
		Municipio mun781 = new Municipio(null, "Brochier", uf23);
		Municipio mun814 = new Municipio(null, "Butiá", uf23);
		Municipio mun833 = new Municipio(null, "Caçapava do Sul", uf23);
		Municipio mun836 = new Municipio(null, "Cacequi", uf23);
		Municipio mun845 = new Municipio(null, "Cachoeira do Sul", uf23);
		Municipio mun854 = new Municipio(null, "Cachoeirinha", uf23);
		Municipio mun861 = new Municipio(null, "Cacique Doble", uf23);
		Municipio mun880 = new Municipio(null, "Caibaté", uf23);
		Municipio mun885 = new Municipio(null, "Caiçara", uf23);
		Municipio mun920 = new Municipio(null, "Camaquã", uf23);
		Municipio mun922 = new Municipio(null, "Camargo", uf23);
		Municipio mun923 = new Municipio(null, "Cambará do Sul", uf23);
		Municipio mun936 = new Municipio(null, "Campestre da Serra", uf23);
		Municipio mun942 = new Municipio(null, "Campina das Missões", uf23);
		Municipio mun951 = new Municipio(null, "Campinas do Sul", uf23);
		Municipio mun962 = new Municipio(null, "Campo Bom", uf23);
		Municipio mun983 = new Municipio(null, "Campo Novo", uf23);
		Municipio mun988 = new Municipio(null, "Campos Borges", uf23);
		Municipio mun1016 = new Municipio(null, "Candelária", uf23);
		Municipio mun1019 = new Municipio(null, "Cândido Godói", uf23);
		Municipio mun1024 = new Municipio(null, "Candiota", uf23);
		Municipio mun1026 = new Municipio(null, "Canela", uf23);
		Municipio mun1029 = new Municipio(null, "Canguçu", uf23);
		Municipio mun1035 = new Municipio(null, "Canoas", uf23);
		Municipio mun1044 = new Municipio(null, "Canudos do Vale", uf23);
		Municipio mun1050 = new Municipio(null, "Capão Bonito do Sul", uf23);
		Municipio mun1052 = new Municipio(null, "Capão da Canoa", uf23);
		Municipio mun1053 = new Municipio(null, "Capão do Cipó", uf23);
		Municipio mun1054 = new Municipio(null, "Capão do Leão", uf23);
		Municipio mun1056 = new Municipio(null, "Capela de Santana", uf23);
		Municipio mun1077 = new Municipio(null, "Capitão", uf23);
		Municipio mun1080 = new Municipio(null, "Capivari do Sul", uf23);
		Municipio mun1085 = new Municipio(null, "Caraá", uf23);
		Municipio mun1104 = new Municipio(null, "Carazinho", uf23);
		Municipio mun1123 = new Municipio(null, "Carlos Barbosa", uf23);
		Municipio mun1125 = new Municipio(null, "Carlos Gomes", uf23);
		Municipio mun1158 = new Municipio(null, "Casca", uf23);
		Municipio mun1163 = new Municipio(null, "Caseiros", uf23);
		Municipio mun1193 = new Municipio(null, "Catuípe", uf23);
		Municipio mun1204 = new Municipio(null, "Caxias do Sul", uf23);
		Municipio mun1216 = new Municipio(null, "Centenário", uf23);
		Municipio mun1228 = new Municipio(null, "Cerrito", uf23);
		Municipio mun1230 = new Municipio(null, "Cerro Branco", uf23);
		Municipio mun1232 = new Municipio(null, "Cerro Grande do Sul", uf23);
		Municipio mun1233 = new Municipio(null, "Cerro Grande", uf23);
		Municipio mun1234 = new Municipio(null, "Cerro Largo", uf23);
		Municipio mun1249 = new Municipio(null, "Chapada", uf23);
		Municipio mun1256 = new Municipio(null, "Charqueadas", uf23);
		Municipio mun1257 = new Municipio(null, "Charrua", uf23);
		Municipio mun1262 = new Municipio(null, "Chiapeta", uf23);
		Municipio mun1267 = new Municipio(null, "Chuí", uf23);
		Municipio mun1269 = new Municipio(null, "Chuvisca", uf23);
		Municipio mun1275 = new Municipio(null, "Cidreira", uf23);
		Municipio mun1278 = new Municipio(null, "Ciríaco", uf23);
		Municipio mun1307 = new Municipio(null, "Colinas", uf23);
		Municipio mun1317 = new Municipio(null, "Colorado", uf23);
		Municipio mun1354 = new Municipio(null, "Condor", uf23);
		Municipio mun1369 = new Municipio(null, "Constantina", uf23);
		Municipio mun1374 = new Municipio(null, "Coqueiro Baixo", uf23);
		Municipio mun1376 = new Municipio(null, "Coqueiros do Sul", uf23);
		Municipio mun1396 = new Municipio(null, "Coronel Barros", uf23);
		Municipio mun1397 = new Municipio(null, "Coronel Bicaco", uf23);
		Municipio mun1409 = new Municipio(null, "Coronel Pilar", uf23);
		Municipio mun1437 = new Municipio(null, "Cotiporã", uf23);
		Municipio mun1441 = new Municipio(null, "Coxilha", uf23);
		Municipio mun1452 = new Municipio(null, "Crissiumal", uf23);
		Municipio mun1455 = new Municipio(null, "Cristal do Sul", uf23);
		Municipio mun1456 = new Municipio(null, "Cristal", uf23);
		Municipio mun1472 = new Municipio(null, "Cruz Alta", uf23);
		Municipio mun1478 = new Municipio(null, "Cruzaltense", uf23);
		Municipio mun1484 = new Municipio(null, "Cruzeiro do Sul", uf23);
		Municipio mun1533 = new Municipio(null, "David Canabarro", uf23);
		Municipio mun1544 = new Municipio(null, "Derrubadas", uf23);
		Municipio mun1551 = new Municipio(null, "Dezesseis de Novembro", uf23);
		Municipio mun1561 = new Municipio(null, "Dilermando de Aguiar", uf23);
		Municipio mun1583 = new Municipio(null, "Dois Irmãos das Missões", uf23);
		Municipio mun1586 = new Municipio(null, "Dois Irmãos", uf23);
		Municipio mun1587 = new Municipio(null, "Dois Lajeados", uf23);
		Municipio mun1597 = new Municipio(null, "Dom Feliciano", uf23);
		Municipio mun1601 = new Municipio(null, "Dom Pedrito", uf23);
		Municipio mun1602 = new Municipio(null, "Dom Pedro de Alcântara", uf23);
		Municipio mun1610 = new Municipio(null, "Dona Francisca", uf23);
		Municipio mun1625 = new Municipio(null, "Doutor Maurício Cardoso", uf23);
		Municipio mun1627 = new Municipio(null, "Doutor Ricardo", uf23);
		Municipio mun1645 = new Municipio(null, "Eldorado do Sul", uf23);
		Municipio mun1660 = new Municipio(null, "Encantado", uf23);
		Municipio mun1662 = new Municipio(null, "Encruzilhada do Sul", uf23);
		Municipio mun1670 = new Municipio(null, "Engenho Velho", uf23);
		Municipio mun1674 = new Municipio(null, "Entre Rios do Sul", uf23);
		Municipio mun1677 = new Municipio(null, "Entre-Ijuís", uf23);
		Municipio mun1681 = new Municipio(null, "Erebango", uf23);
		Municipio mun1682 = new Municipio(null, "Erechim", uf23);
		Municipio mun1686 = new Municipio(null, "Ernestina", uf23);
		Municipio mun1687 = new Municipio(null, "Erval Grande", uf23);
		Municipio mun1688 = new Municipio(null, "Erval Seco", uf23);
		Municipio mun1692 = new Municipio(null, "Esmeralda", uf23);
		Municipio mun1695 = new Municipio(null, "Esperança do Sul", uf23);
		Municipio mun1709 = new Municipio(null, "Espumoso", uf23);
		Municipio mun1710 = new Municipio(null, "Estação", uf23);
		Municipio mun1711 = new Municipio(null, "Estância Velha", uf23);
		Municipio mun1713 = new Municipio(null, "Esteio", uf23);
		Municipio mun1724 = new Municipio(null, "Estrela Velha", uf23);
		Municipio mun1725 = new Municipio(null, "Estrela", uf23);
		Municipio mun1728 = new Municipio(null, "Eugênio de Castro", uf23);
		Municipio mun1736 = new Municipio(null, "Fagundes Varela", uf23);
		Municipio mun1744 = new Municipio(null, "Farroupilha", uf23);
		Municipio mun1750 = new Municipio(null, "Faxinal do Soturno", uf23);
		Municipio mun1753 = new Municipio(null, "Faxinalzinho", uf23);
		Municipio mun1756 = new Municipio(null, "Fazenda Vilanova", uf23);
		Municipio mun1770 = new Municipio(null, "Feliz", uf23);
		Municipio mun1800 = new Municipio(null, "Flores da Cunha", uf23);
		Municipio mun1811 = new Municipio(null, "Floriano Peixoto", uf23);
		Municipio mun1818 = new Municipio(null, "Fontoura Xavier", uf23);
		Municipio mun1820 = new Municipio(null, "Formigueiro", uf23);
		Municipio mun1829 = new Municipio(null, "Forquetinha", uf23);
		Municipio mun1835 = new Municipio(null, "Fortaleza dos Valos", uf23);
		Municipio mun1858 = new Municipio(null, "Frederico Westphalen", uf23);
		Municipio mun1887 = new Municipio(null, "Garibaldi", uf23);
		Municipio mun1890 = new Municipio(null, "Garruchos", uf23);
		Municipio mun1895 = new Municipio(null, "Gaurama", uf23);
		Municipio mun1899 = new Municipio(null, "General Câmara", uf23);
		Municipio mun1905 = new Municipio(null, "Gentil", uf23);
		Municipio mun1908 = new Municipio(null, "Getúlio Vargas", uf23);
		Municipio mun1911 = new Municipio(null, "Giruá", uf23);
		Municipio mun1918 = new Municipio(null, "Glorinha", uf23);
		Municipio mun1959 = new Municipio(null, "Gramado dos Loureiros", uf23);
		Municipio mun1960 = new Municipio(null, "Gramado Xavier", uf23);
		Municipio mun1961 = new Municipio(null, "Gramado", uf23);
		Municipio mun1969 = new Municipio(null, "Gravataí", uf23);
		Municipio mun1974 = new Municipio(null, "Guabiju", uf23);
		Municipio mun1978 = new Municipio(null, "Guaíba", uf23);
		Municipio mun1998 = new Municipio(null, "Guaporé", uf23);
		Municipio mun2015 = new Municipio(null, "Guarani das Missões", uf23);
		Municipio mun2053 = new Municipio(null, "Harmonia", uf23);
		Municipio mun2059 = new Municipio(null, "Herval", uf23);
		Municipio mun2060 = new Municipio(null, "Herveiras", uf23);
		Municipio mun2067 = new Municipio(null, "Horizontina", uf23);
		Municipio mun2070 = new Municipio(null, "Hulha Negra", uf23);
		Municipio mun2071 = new Municipio(null, "Humaitá", uf23);
		Municipio mun2082 = new Municipio(null, "Ibarama", uf23);
		Municipio mun2090 = new Municipio(null, "Ibiaçá", uf23);
		Municipio mun2110 = new Municipio(null, "Ibiraiaras", uf23);
		Municipio mun2115 = new Municipio(null, "Ibirapuitã", uf23);
		Municipio mun2119 = new Municipio(null, "Ibirubá", uf23);
		Municipio mun2154 = new Municipio(null, "Igrejinha", uf23);
		Municipio mun2165 = new Municipio(null, "Ijuí", uf23);
		Municipio mun2175 = new Municipio(null, "Ilópolis", uf23);
		Municipio mun2180 = new Municipio(null, "Imbé", uf23);
		Municipio mun2184 = new Municipio(null, "Imigrante", uf23);
		Municipio mun2194 = new Municipio(null, "Independência", uf23);
		Municipio mun2206 = new Municipio(null, "Inhacorá", uf23);
		Municipio mun2226 = new Municipio(null, "Ipê", uf23);
		Municipio mun2238 = new Municipio(null, "Ipiranga do Sul", uf23);
		Municipio mun2263 = new Municipio(null, "Iraí", uf23);
		Municipio mun2283 = new Municipio(null, "Itaara", uf23);
		Municipio mun2303 = new Municipio(null, "Itacurubi", uf23);
		Municipio mun2397 = new Municipio(null, "Itapuca", uf23);
		Municipio mun2403 = new Municipio(null, "Itaqui", uf23);
		Municipio mun2412 = new Municipio(null, "Itati", uf23);
		Municipio mun2415 = new Municipio(null, "Itatiba do Sul", uf23);
		Municipio mun2460 = new Municipio(null, "Ivorá", uf23);
		Municipio mun2461 = new Municipio(null, "Ivoti", uf23);
		Municipio mun2467 = new Municipio(null, "Jaboticaba", uf23);
		Municipio mun2485 = new Municipio(null, "Jacuizinho", uf23);
		Municipio mun2489 = new Municipio(null, "Jacutinga", uf23);
		Municipio mun2493 = new Municipio(null, "Jaguarão", uf23);
		Municipio mun2497 = new Municipio(null, "Jaguari", uf23);
		Municipio mun2533 = new Municipio(null, "Jaquirana", uf23);
		Municipio mun2548 = new Municipio(null, "Jari", uf23);
		Municipio mun2605 = new Municipio(null, "Jóia", uf23);
		Municipio mun2633 = new Municipio(null, "Júlio de Castilhos", uf23);
		Municipio mun2681 = new Municipio(null, "Lagoa Bonita do Sul", uf23);
		Municipio mun2700 = new Municipio(null, "Lagoa dos Três Cantos", uf23);
		Municipio mun2712 = new Municipio(null, "Lagoa Vermelha", uf23);
		Municipio mun2714 = new Municipio(null, "Lagoão", uf23);
		Municipio mun2721 = new Municipio(null, "Lajeado do Bugre", uf23);
		Municipio mun2724 = new Municipio(null, "Lajeado", uf23);
		Municipio mun2755 = new Municipio(null, "Lavras do Sul", uf23);
		Municipio mun2768 = new Municipio(null, "Liberato Salzano", uf23);
		Municipio mun2783 = new Municipio(null, "Lindolfo Collor", uf23);
		Municipio mun2784 = new Municipio(null, "Linha Nova", uf23);
		Municipio mun2829 = new Municipio(null, "Maçambara", uf23);
		Municipio mun2842 = new Municipio(null, "Machadinho", uf23);
		Municipio mun2880 = new Municipio(null, "Mampituba", uf23);
		Municipio mun2901 = new Municipio(null, "Manoel Viana", uf23);
		Municipio mun2906 = new Municipio(null, "Maquiné", uf23);
		Municipio mun2928 = new Municipio(null, "Maratá", uf23);
		Municipio mun2930 = new Municipio(null, "Marau", uf23);
		Municipio mun2937 = new Municipio(null, "Marcelino Ramos", uf23);
		Municipio mun2952 = new Municipio(null, "Mariana Pimentel", uf23);
		Municipio mun2954 = new Municipio(null, "Mariano Moro", uf23);
		Municipio mun2976 = new Municipio(null, "Marques de Souza", uf23);
		Municipio mun2995 = new Municipio(null, "Mata", uf23);
		Municipio mun3011 = new Municipio(null, "Mato Castelhano", uf23);
		Municipio mun3013 = new Municipio(null, "Mato Leitão", uf23);
		Municipio mun3014 = new Municipio(null, "Mato Queimado", uf23);
		Municipio mun3033 = new Municipio(null, "Maximiliano de Almeida", uf23);
		Municipio mun3068 = new Municipio(null, "Minas do Leão", uf23);
		Municipio mun3082 = new Municipio(null, "Miraguaí", uf23);
		Municipio mun3130 = new Municipio(null, "Montauri", uf23);
		Municipio mun3136 = new Municipio(null, "Monte Alegre dos Campos", uf23);
		Municipio mun3143 = new Municipio(null, "Monte Belo do Sul", uf23);
		Municipio mun3162 = new Municipio(null, "Montenegro", uf23);
		Municipio mun3175 = new Municipio(null, "Mormaço", uf23);
		Municipio mun3178 = new Municipio(null, "Morrinhos do Sul", uf23);
		Municipio mun3190 = new Municipio(null, "Morro Redondo", uf23);
		Municipio mun3191 = new Municipio(null, "Morro Reuter", uf23);
		Municipio mun3197 = new Municipio(null, "Mostardas", uf23);
		Municipio mun3204 = new Municipio(null, "Muçum", uf23);
		Municipio mun3207 = new Municipio(null, "Muitos Capões", uf23);
		Municipio mun3208 = new Municipio(null, "Muliterno", uf23);
		Municipio mun3235 = new Municipio(null, "Não-Me-Toque", uf23);
		Municipio mun3261 = new Municipio(null, "Nicolau Vergueiro", uf23);
		Municipio mun3272 = new Municipio(null, "Nonoai", uf23);
		Municipio mun3288 = new Municipio(null, "Nova Alvorada", uf23);
		Municipio mun3292 = new Municipio(null, "Nova Araçá", uf23);
		Municipio mun3296 = new Municipio(null, "Nova Bassano", uf23);
		Municipio mun3298 = new Municipio(null, "Nova Boa Vista", uf23);
		Municipio mun3301 = new Municipio(null, "Nova Bréscia", uf23);
		Municipio mun3306 = new Municipio(null, "Nova Candelária", uf23);
		Municipio mun3316 = new Municipio(null, "Nova Esperança do Sul", uf23);
		Municipio mun3327 = new Municipio(null, "Nova Hartz", uf23);
		Municipio mun3355 = new Municipio(null, "Nova Pádua", uf23);
		Municipio mun3356 = new Municipio(null, "Nova Palma", uf23);
		Municipio mun3358 = new Municipio(null, "Nova Petrópolis", uf23);
		Municipio mun3362 = new Municipio(null, "Nova Prata", uf23);
		Municipio mun3363 = new Municipio(null, "Nova Ramada", uf23);
		Municipio mun3366 = new Municipio(null, "Nova Roma do Sul", uf23);
		Municipio mun3373 = new Municipio(null, "Nova Santa Rita", uf23);
		Municipio mun3393 = new Municipio(null, "Novo Barreiro", uf23);
		Municipio mun3395 = new Municipio(null, "Novo Cabrais", uf23);
		Municipio mun3398 = new Municipio(null, "Novo Hamburgo", uf23);
		Municipio mun3408 = new Municipio(null, "Novo Machado", uf23);
		Municipio mun3419 = new Municipio(null, "Novo Tiradentes", uf23);
		Municipio mun3421 = new Municipio(null, "Novo Xingu", uf23);
		Municipio mun3467 = new Municipio(null, "Osório", uf23);
		Municipio mun3509 = new Municipio(null, "Paim Filho", uf23);
		Municipio mun3524 = new Municipio(null, "Palmares do Sul", uf23);
		Municipio mun3531 = new Municipio(null, "Palmeira das Missões", uf23);
		Municipio mun3548 = new Municipio(null, "Palmitinho", uf23);
		Municipio mun3553 = new Municipio(null, "Panambi", uf23);
		Municipio mun3557 = new Municipio(null, "Pantano Grande", uf23);
		Municipio mun3569 = new Municipio(null, "Paraí", uf23);
		Municipio mun3575 = new Municipio(null, "Paraíso do Sul", uf23);
		Municipio mun3607 = new Municipio(null, "Pareci Novo", uf23);
		Municipio mun3621 = new Municipio(null, "Parobé", uf23);
		Municipio mun3624 = new Municipio(null, "Passa Sete", uf23);
		Municipio mun3635 = new Municipio(null, "Passo do Sobrado", uf23);
		Municipio mun3636 = new Municipio(null, "Passo Fundo", uf23);
		Municipio mun3669 = new Municipio(null, "Paulo Bento", uf23);
		Municipio mun3676 = new Municipio(null, "Paverama", uf23);
		Municipio mun3700 = new Municipio(null, "Pedras Altas", uf23);
		Municipio mun3720 = new Municipio(null, "Pedro Osório", uf23);
		Municipio mun3727 = new Municipio(null, "Pejuçara", uf23);
		Municipio mun3728 = new Municipio(null, "Pelotas", uf23);
		Municipio mun3766 = new Municipio(null, "Picada Café", uf23);
		Municipio mun3799 = new Municipio(null, "Pinhal da Serra", uf23);
		Municipio mun3801 = new Municipio(null, "Pinhal Grande", uf23);
		Municipio mun3802 = new Municipio(null, "Pinhal", uf23);
		Municipio mun3809 = new Municipio(null, "Pinheirinho do Vale", uf23);
		Municipio mun3810 = new Municipio(null, "Pinheiro Machado", uf23);
		Municipio mun3841 = new Municipio(null, "Pirapó", uf23);
		Municipio mun3848 = new Municipio(null, "Piratini", uf23);
		Municipio mun3875 = new Municipio(null, "Planalto", uf23);
		Municipio mun3886 = new Municipio(null, "Poço das Antas", uf23);
		Municipio mun3912 = new Municipio(null, "Pontão", uf23);
		Municipio mun3919 = new Municipio(null, "Ponte Preta", uf23);
		Municipio mun3934 = new Municipio(null, "Portão", uf23);
		Municipio mun3944 = new Municipio(null, "Porto Alegre", uf23);
		Municipio mun3961 = new Municipio(null, "Porto Lucena", uf23);
		Municipio mun3962 = new Municipio(null, "Porto Mauá", uf23);
		Municipio mun3972 = new Municipio(null, "Porto Vera Cruz", uf23);
		Municipio mun3975 = new Municipio(null, "Porto Xavier", uf23);
		Municipio mun3986 = new Municipio(null, "Pouso Novo", uf23);
		Municipio mun4023 = new Municipio(null, "Presidente Lucena", uf23);
		Municipio mun4042 = new Municipio(null, "Progresso", uf23);
		Municipio mun4045 = new Municipio(null, "Protásio Alves", uf23);
		Municipio mun4050 = new Municipio(null, "Putinga", uf23);
		Municipio mun4053 = new Municipio(null, "Quaraí", uf23);
		Municipio mun4061 = new Municipio(null, "Quatro Irmãos", uf23);
		Municipio mun4074 = new Municipio(null, "Quevedos", uf23);
		Municipio mun4079 = new Municipio(null, "Quinze de Novembro", uf23);
		Municipio mun4113 = new Municipio(null, "Redentora", uf23);
		Municipio mun4119 = new Municipio(null, "Relvado", uf23);
		Municipio mun4131 = new Municipio(null, "Restinga Seca", uf23);
		Municipio mun4214 = new Municipio(null, "Rio dos Índios", uf23);
		Municipio mun4220 = new Municipio(null, "Rio Grande", uf23);
		Municipio mun4231 = new Municipio(null, "Rio Pardo", uf23);
		Municipio mun4245 = new Municipio(null, "Riozinho", uf23);
		Municipio mun4249 = new Municipio(null, "Roca Sales", uf23);
		Municipio mun4252 = new Municipio(null, "Rodeio Bonito", uf23);
		Municipio mun4258 = new Municipio(null, "Rolador", uf23);
		Municipio mun4260 = new Municipio(null, "Rolante", uf23);
		Municipio mun4265 = new Municipio(null, "Ronda Alta", uf23);
		Municipio mun4266 = new Municipio(null, "Rondinha", uf23);
		Municipio mun4271 = new Municipio(null, "Roque Gonzales", uf23);
		Municipio mun4277 = new Municipio(null, "Rosário do Sul", uf23);
		Municipio mun4297 = new Municipio(null, "Sagrada Família", uf23);
		Municipio mun4300 = new Municipio(null, "Saldanha Marinho", uf23);
		Municipio mun4323 = new Municipio(null, "Salto do Jacuí", uf23);
		Municipio mun4328 = new Municipio(null, "Salvador das Missões", uf23);
		Municipio mun4329 = new Municipio(null, "Salvador do Sul", uf23);
		Municipio mun4334 = new Municipio(null, "Sananduva", uf23);
		Municipio mun4348 = new Municipio(null, "Santa Bárbara do Sul", uf23);
		Municipio mun4356 = new Municipio(null, "Santa Cecília do Sul", uf23);
		Municipio mun4360 = new Municipio(null, "Santa Clara do Sul", uf23);
		Municipio mun4376 = new Municipio(null, "Santa Cruz do Sul", uf23);
		Municipio mun4423 = new Municipio(null, "Santa Margarida do Sul", uf23);
		Municipio mun4432 = new Municipio(null, "Santa Maria do Herval", uf23);
		Municipio mun4440 = new Municipio(null, "Santa Maria", uf23);
		Municipio mun4471 = new Municipio(null, "Santa Rosa", uf23);
		Municipio mun4479 = new Municipio(null, "Santa Tereza", uf23);
		Municipio mun4487 = new Municipio(null, "Santa Vitória do Palmar", uf23);
		Municipio mun4490 = new Municipio(null, "Santana da Boa Vista", uf23);
		Municipio mun4505 = new Municipio(null, "Santana do Livramento", uf23);
		Municipio mun4524 = new Municipio(null, "Santiago", uf23);
		Municipio mun4533 = new Municipio(null, "Santo Ângelo", uf23);
		Municipio mun4536 = new Municipio(null, "Santo Antônio da Patrulha", uf23);
		Municipio mun4538 = new Municipio(null, "Santo Antônio das Missões", uf23);
		Municipio mun4557 = new Municipio(null, "Santo Antônio do Palma", uf23);
		Municipio mun4560 = new Municipio(null, "Santo Antônio do Planalto", uf23);
		Municipio mun4568 = new Municipio(null, "Santo Augusto", uf23);
		Municipio mun4569 = new Municipio(null, "Santo Cristo", uf23);
		Municipio mun4571 = new Municipio(null, "Santo Expedito do Sul", uf23);
		Municipio mun4596 = new Municipio(null, "São Borja", uf23);
		Municipio mun4618 = new Municipio(null, "São Domingos do Sul", uf23);
		Municipio mun4636 = new Municipio(null, "São Francisco de Assis", uf23);
		Municipio mun4640 = new Municipio(null, "São Francisco de Paula", uf23);
		Municipio mun4658 = new Municipio(null, "São Gabriel", uf23);
		Municipio mun4677 = new Municipio(null, "São Jerônimo", uf23);
		Municipio mun4693 = new Municipio(null, "São João da Urtiga", uf23);
		Municipio mun4718 = new Municipio(null, "São João do Polêsine", uf23);
		Municipio mun4737 = new Municipio(null, "São Jorge", uf23);
		Municipio mun4749 = new Municipio(null, "São José das Missões", uf23);
		Municipio mun4771 = new Municipio(null, "São José do Herval", uf23);
		Municipio mun4772 = new Municipio(null, "São José do Hortêncio", uf23);
		Municipio mun4773 = new Municipio(null, "São José do Inhacorá", uf23);
		Municipio mun4777 = new Municipio(null, "São José do Norte", uf23);
		Municipio mun4778 = new Municipio(null, "São José do Ouro", uf23);
		Municipio mun4787 = new Municipio(null, "São José do Sul", uf23);
		Municipio mun4790 = new Municipio(null, "São José dos Ausentes", uf23);
		Municipio mun4799 = new Municipio(null, "São Leopoldo", uf23);
		Municipio mun4804 = new Municipio(null, "São Lourenço do Sul", uf23);
		Municipio mun4815 = new Municipio(null, "São Luiz Gonzaga", uf23);
		Municipio mun4820 = new Municipio(null, "São Marcos", uf23);
		Municipio mun4821 = new Municipio(null, "São Martinho da Serra", uf23);
		Municipio mun4822 = new Municipio(null, "São Martinho", uf23);
		Municipio mun4831 = new Municipio(null, "São Miguel das Missões", uf23);
		Municipio mun4848 = new Municipio(null, "São Nicolau", uf23);
		Municipio mun4850 = new Municipio(null, "São Paulo das Missões", uf23);
		Municipio mun4857 = new Municipio(null, "São Pedro da Serra", uf23);
		Municipio mun4859 = new Municipio(null, "São Pedro das Missões", uf23);
		Municipio mun4861 = new Municipio(null, "São Pedro do Butiá", uf23);
		Municipio mun4867 = new Municipio(null, "São Pedro do Sul", uf23);
		Municipio mun4891 = new Municipio(null, "São Sebastião do Caí", uf23);
		Municipio mun4903 = new Municipio(null, "São Sepé", uf23);
		Municipio mun4911 = new Municipio(null, "São Valentim do Sul", uf23);
		Municipio mun4912 = new Municipio(null, "São Valentim", uf23);
		Municipio mun4914 = new Municipio(null, "São Valério do Sul", uf23);
		Municipio mun4915 = new Municipio(null, "São Vendelino", uf23);
		Municipio mun4917 = new Municipio(null, "São Vicente do Sul", uf23);
		Municipio mun4925 = new Municipio(null, "Sapiranga", uf23);
		Municipio mun4927 = new Municipio(null, "Sapucaia do Sul", uf23);
		Municipio mun4933 = new Municipio(null, "Sarandi", uf23);
		Municipio mun4952 = new Municipio(null, "Seberi", uf23);
		Municipio mun4953 = new Municipio(null, "Sede Nova", uf23);
		Municipio mun4954 = new Municipio(null, "Segredo", uf23);
		Municipio mun4955 = new Municipio(null, "Selbach", uf23);
		Municipio mun4974 = new Municipio(null, "Senador Salgado Filho", uf23);
		Municipio mun4980 = new Municipio(null, "Sentinela do Sul", uf23);
		Municipio mun4982 = new Municipio(null, "Serafina Corrêa", uf23);
		Municipio mun4986 = new Municipio(null, "Sério", uf23);
		Municipio mun5027 = new Municipio(null, "Sertão Santana", uf23);
		Municipio mun5028 = new Municipio(null, "Sertão", uf23);
		Municipio mun5032 = new Municipio(null, "Sete de Setembro", uf23);
		Municipio mun5036 = new Municipio(null, "Severiano de Almeida", uf23);
		Municipio mun5045 = new Municipio(null, "Silveira Martins", uf23);
		Municipio mun5057 = new Municipio(null, "Sinimbu", uf23);
		Municipio mun5068 = new Municipio(null, "Sobradinho", uf23);
		Municipio mun5078 = new Municipio(null, "Soledade", uf23);
		Municipio mun5103 = new Municipio(null, "Tabaí", uf23);
		Municipio mun5147 = new Municipio(null, "Tapejara", uf23);
		Municipio mun5148 = new Municipio(null, "Tapera", uf23);
		Municipio mun5151 = new Municipio(null, "Tapes", uf23);
		Municipio mun5159 = new Municipio(null, "Taquara", uf23);
		Municipio mun5164 = new Municipio(null, "Taquari", uf23);
		Municipio mun5169 = new Municipio(null, "Taquaruçu do Sul", uf23);
		Municipio mun5182 = new Municipio(null, "Tavares", uf23);
		Municipio mun5195 = new Municipio(null, "Tenente Portela", uf23);
		Municipio mun5211 = new Municipio(null, "Terra de Areia", uf23);
		Municipio mun5220 = new Municipio(null, "Teutônia", uf23);
		Municipio mun5239 = new Municipio(null, "Tio Hugo", uf23);
		Municipio mun5240 = new Municipio(null, "Tiradentes do Sul", uf23);
		Municipio mun5257 = new Municipio(null, "Toropi", uf23);
		Municipio mun5259 = new Municipio(null, "Torres", uf23);
		Municipio mun5269 = new Municipio(null, "Tramandaí", uf23);
		Municipio mun5270 = new Municipio(null, "Travesseiro", uf23);
		Municipio mun5273 = new Municipio(null, "Três Arroios", uf23);
		Municipio mun5276 = new Municipio(null, "Três Cachoeiras", uf23);
		Municipio mun5278 = new Municipio(null, "Três Coroas", uf23);
		Municipio mun5279 = new Municipio(null, "Três de Maio", uf23);
		Municipio mun5280 = new Municipio(null, "Três Forquilhas", uf23);
		Municipio mun5284 = new Municipio(null, "Três Palmeiras", uf23);
		Municipio mun5285 = new Municipio(null, "Três Passos", uf23);
		Municipio mun5292 = new Municipio(null, "Trindade do Sul", uf23);
		Municipio mun5298 = new Municipio(null, "Triunfo", uf23);
		Municipio mun5305 = new Municipio(null, "Tucunduva", uf23);
		Municipio mun5312 = new Municipio(null, "Tunas", uf23);
		Municipio mun5318 = new Municipio(null, "Tupanci do Sul", uf23);
		Municipio mun5319 = new Municipio(null, "Tupanciretã", uf23);
		Municipio mun5320 = new Municipio(null, "Tupandi", uf23);
		Municipio mun5321 = new Municipio(null, "Tuparendi", uf23);
		Municipio mun5332 = new Municipio(null, "Turuçu", uf23);
		Municipio mun5355 = new Municipio(null, "Ubiretama", uf23);
		Municipio mun5372 = new Municipio(null, "União da Serra", uf23);
		Municipio mun5381 = new Municipio(null, "Unistalda", uf23);
		Municipio mun5400 = new Municipio(null, "Uruguaiana", uf23);
		Municipio mun5408 = new Municipio(null, "Vacaria", uf23);
		Municipio mun5412 = new Municipio(null, "Vale do Sol", uf23);
		Municipio mun5413 = new Municipio(null, "Vale Real", uf23);
		Municipio mun5414 = new Municipio(null, "Vale Verde", uf23);
		Municipio mun5423 = new Municipio(null, "Vanini", uf23);
		Municipio mun5455 = new Municipio(null, "Venâncio Aires", uf23);
		Municipio mun5462 = new Municipio(null, "Vera Cruz", uf23);
		Municipio mun5467 = new Municipio(null, "Veranópolis", uf23);
		Municipio mun5477 = new Municipio(null, "Vespasiano Correa", uf23);
		Municipio mun5479 = new Municipio(null, "Viadutos", uf23);
		Municipio mun5480 = new Municipio(null, "Viamão", uf23);
		Municipio mun5485 = new Municipio(null, "Vicente Dutra", uf23);
		Municipio mun5492 = new Municipio(null, "Victor Graeff", uf23);
		Municipio mun5501 = new Municipio(null, "Vila Flores", uf23);
		Municipio mun5502 = new Municipio(null, "Vila Lângaro", uf23);
		Municipio mun5503 = new Municipio(null, "Vila Maria", uf23);
		Municipio mun5505 = new Municipio(null, "Vila Nova do Sul", uf23);
		Municipio mun5523 = new Municipio(null, "Vista Alegre do Prata", uf23);
		Municipio mun5524 = new Municipio(null, "Vista Alegre", uf23);
		Municipio mun5525 = new Municipio(null, "Vista Gaúcha", uf23);
		Municipio mun5530 = new Municipio(null, "Vitória das Missões", uf23);
		Municipio mun5549 = new Municipio(null, "Westfália", uf23);
		Municipio mun5553 = new Municipio(null, "Xangri-lá", uf23);

		municipioRepository.saveAll(Arrays.asList(mun1044, mun1050, mun1052, mun1053, mun1054, mun1056, mun1077, mun1080, 
			mun1085, mun1104, mun1123, mun1125, mun1158, mun1163, mun1193, mun1204, 
			mun1216, mun1228, mun1230, mun1232, mun1233, mun1234, mun1249, mun1256, 
			mun1257, mun1262, mun1267, mun1269, mun1275, mun1278, mun1307, mun1317, 
			mun129, mun145, mun152, mun183, mun191, mun203, mun232, mun254, 
			mun1354, mun1369, mun1374, mun1376, mun1396, mun1397, mun1409, mun1437, 
			mun1441, mun1452, mun1455, mun1456, mun1472, mun1478, mun1484, mun1533, 
			mun1544, mun1551, mun1561, mun1583, mun1586, mun1587, mun1597, mun1601, 
			mun1602, mun1610, mun1625, mun1627, mun1645, mun1660, mun1662, mun1670, 
			mun1674, mun1677, mun1681, mun1682, mun1686, mun1687, mun1688, mun1692, 
			mun1695, mun1709, mun1710, mun1711, mun1713, mun1724, mun1725, mun1728, 
			mun1736, mun1744, mun1750, mun1753, mun1756, mun1770, mun1800, mun1811, 
			mun1818, mun1820, mun1829, mun1835, mun1858, mun1887, mun1890, mun1895, 
			mun1899, mun1905, mun1908, mun1911, mun1918, mun1959, mun1960, mun1961, 
			mun1969, mun1974, mun1978, mun1998, mun2015, mun2053, mun2059, mun2060, 
			mun2067, mun2070, mun2071, mun2082, mun2090, mun2110, mun2115, mun2119, 
			mun2154, mun2165, mun2175, mun2180, mun2184, mun2194, mun2206, mun2226, 
			mun2238, mun2263, mun2283, mun2303, mun2397, mun2403, mun2412, mun2415, 
			mun2460, mun2461, mun2467, mun2485, mun2489, mun2493, mun2497, mun2533, 
			mun25, mun62, mun76, mun86, mun102, mun105, mun106, mun125, 
			mun2548, mun2605, mun2633, mun2681, mun2700, mun2712, mun2714, mun2721, 
			mun268, mun325, mun347, mun354, mun394, mun395, mun396, mun397, 
			mun2724, mun2755, mun2768, mun2783, mun2784, mun2829, mun2842, mun2880, 
			mun2901, mun2906, mun2928, mun2930, mun2937, mun2952, mun2954, mun2976, 
			mun2995, mun3011, mun3013, mun3014, mun3033, mun3068, mun3082, mun3130, 
			mun3136, mun3143, mun3162, mun3175, mun3178, mun3190, mun3191, mun3197, 
			mun3204, mun3207, mun3208, mun3235, mun3261, mun3272, mun3288, mun3292, 
			mun3296, mun3298, mun3301, mun3306, mun3316, mun3327, mun3355, mun3356, 
			mun3358, mun3362, mun3363, mun3366, mun3373, mun3393, mun3395, mun3398, 
			mun3408, mun3419, mun3421, mun3467, mun3509, mun3524, mun3531, mun3548, 
			mun3553, mun3557, mun3569, mun3575, mun3607, mun3621, mun3624, mun3635, 
			mun3636, mun3669, mun3676, mun3700, mun3720, mun3727, mun3728, mun3766, 
			mun3799, mun3801, mun3802, mun3809, mun3810, mun3841, mun3848, mun3875, 
			mun3886, mun3912, mun3919, mun3934, mun3944, mun3961, mun3962, mun3972, 
			mun3975, mun3986, mun4023, mun4042, mun4045, mun4050, mun4053, mun4061, 
			mun398, mun399, mun405, mun427, mun429, mun453, mun470, mun488, 
			mun4074, mun4079, mun4113, mun4119, mun4131, mun4214, mun4220, mun4231, 
			mun4245, mun4249, mun4252, mun4258, mun4260, mun4265, mun4266, mun4271, 
			mun4277, mun4297, mun4300, mun4323, mun4328, mun4329, mun4334, mun4348, 
			mun4356, mun4360, mun4376, mun4423, mun4432, mun4440, mun4471, mun4479, 
			mun4487, mun4490, mun4505, mun4524, mun4533, mun4536, mun4538, mun4557, 
			mun4560, mun4568, mun4569, mun4571, mun4596, mun4618, mun4636, mun4640, 
			mun4658, mun4677, mun4693, mun4718, mun4737, mun4749, mun4771, mun4772, 
			mun4773, mun4777, mun4778, mun4787, mun4790, mun4799, mun4804, mun4815, 
			mun4820, mun4821, mun4822, mun4831, mun4848, mun4850, mun4857, mun4859, 
			mun4861, mun4867, mun4891, mun4903, mun4911, mun4912, mun4914, mun4915, 
			mun4917, mun4925, mun4927, mun4933, mun4952, mun4953, mun4954, mun4955, 
			mun492, mun493, mun520, mun525, mun526, mun527, mun531, mun537, 
			mun4974, mun4980, mun4982, mun4986, mun5027, mun5028, mun5032, mun5036, 
			mun5045, mun5057, mun5068, mun5078, mun5103, mun5147, mun5148, mun5151, 
			mun5159, mun5164, mun5169, mun5182, mun5195, mun5211, mun5220, mun5239, 
			mun5240, mun5257, mun5259, mun5269, mun5270, mun5273, mun5276, mun5278, 
			mun5279, mun5280, mun5284, mun5285, mun5292, mun5298, mun5305, mun5312, 
			mun5318, mun5319, mun5320, mun5321, mun5332, mun5355, mun5372, mun5381, 
			mun5400, mun5408, mun5412, mun5413, mun5414, mun5423, mun5455, mun5462, 
			mun5467, mun5477, mun5479, mun5480, mun5485, mun5492, mun5501, mun5502, 
			mun5503, mun5505, mun5523, mun5524, mun5525, mun5530, mun5549, mun5553, 
			mun555, mun601, mun605, mun642, mun643, mun644, mun646, mun648, 
			mun691, mun695, mun696, mun698, mun719, mun732, mun738, mun741, 
			mun781, mun814, mun833, mun836, mun845, mun854, mun861, mun880, 
			mun885, mun920, mun922, mun923, mun936, mun942, mun951, mun962, 
			mun983, mun988, mun1016, mun1019, mun1024, mun1026, mun1029, mun1035));

	}
	
	private void instanciaMunUf24(UF uf24) {
		Municipio mun11 = new Municipio(null, "Abdon Batista", uf24);
		Municipio mun13 = new Municipio(null, "Abelardo Luz", uf24);
		Municipio mun44 = new Municipio(null, "Agrolândia", uf24);
		Municipio mun45 = new Municipio(null, "Agronômica", uf24);
		Municipio mun56 = new Municipio(null, "Água Doce", uf24);
		Municipio mun67 = new Municipio(null, "Águas de Chapecó", uf24);
		Municipio mun72 = new Municipio(null, "Águas Frias", uf24);
		Municipio mun74 = new Municipio(null, "Águas Mornas", uf24);
		Municipio mun115 = new Municipio(null, "Alfredo Wagner", uf24);
		Municipio mun148 = new Municipio(null, "Alto Bela Vista", uf24);
		Municipio mun225 = new Municipio(null, "Anchieta", uf24);
		Municipio mun238 = new Municipio(null, "Angelina", uf24);
		Municipio mun251 = new Municipio(null, "Anita Garibaldi", uf24);
		Municipio mun252 = new Municipio(null, "Anitápolis", uf24);
		Municipio mun261 = new Municipio(null, "Antônio Carlos", uf24);
		Municipio mun281 = new Municipio(null, "Apiúna", uf24);
		Municipio mun292 = new Municipio(null, "Arabutã", uf24);
		Municipio mun340 = new Municipio(null, "Araquari", uf24);
		Municipio mun342 = new Municipio(null, "Araranguá", uf24);
		Municipio mun386 = new Municipio(null, "Armazém", uf24);
		Municipio mun400 = new Municipio(null, "Arroio Trinta", uf24);
		Municipio mun404 = new Municipio(null, "Arvoredo", uf24);
		Municipio mun406 = new Municipio(null, "Ascurra", uf24);
		Municipio mun420 = new Municipio(null, "Atalanta", uf24);
		Municipio mun435 = new Municipio(null, "Aurora", uf24);
		Municipio mun466 = new Municipio(null, "Balneário Arroio do Silva", uf24);
		Municipio mun467 = new Municipio(null, "Balneário Barra do Sul", uf24);
		Municipio mun468 = new Municipio(null, "Balneário Camboriú", uf24);
		Municipio mun469 = new Municipio(null, "Balneário Gaivota", uf24);
		Municipio mun480 = new Municipio(null, "Bandeirante", uf24);
		Municipio mun504 = new Municipio(null, "Barra Bonita", uf24);
		Municipio mun534 = new Municipio(null, "Barra Velha", uf24);
		Municipio mun576 = new Municipio(null, "Bela Vista do Toldo", uf24);
		Municipio mun588 = new Municipio(null, "Belmonte", uf24);
		Municipio mun599 = new Municipio(null, "Benedito Novo", uf24);
		Municipio mun623 = new Municipio(null, "Biguaçu", uf24);
		Municipio mun630 = new Municipio(null, "Blumenau", uf24);
		Municipio mun655 = new Municipio(null, "Bocaina do Sul", uf24);
		Municipio mun667 = new Municipio(null, "Bom Jardim da Serra", uf24);
		Municipio mun683 = new Municipio(null, "Bom Jesus do Oeste", uf24);
		Municipio mun692 = new Municipio(null, "Bom Jesus", uf24);
		Municipio mun699 = new Municipio(null, "Bom Retiro", uf24);
		Municipio mun705 = new Municipio(null, "Bombinhas", uf24);
		Municipio mun737 = new Municipio(null, "Botuverá", uf24);
		Municipio mun739 = new Municipio(null, "Braço do Norte", uf24);
		Municipio mun740 = new Municipio(null, "Braço do Trombudo", uf24);
		Municipio mun787 = new Municipio(null, "Brunópolis", uf24);
		Municipio mun788 = new Municipio(null, "Brusque", uf24);
		Municipio mun832 = new Municipio(null, "Caçador", uf24);
		Municipio mun881 = new Municipio(null, "Caibi", uf24);
		Municipio mun911 = new Municipio(null, "Calmon", uf24);
		Municipio mun927 = new Municipio(null, "Camboriú", uf24);
		Municipio mun958 = new Municipio(null, "Campo Alegre", uf24);
		Municipio mun960 = new Municipio(null, "Campo Belo do Sul", uf24);
		Municipio mun968 = new Municipio(null, "Campo Erê", uf24);
		Municipio mun995 = new Municipio(null, "Campos Novos", uf24);
		Municipio mun1027 = new Municipio(null, "Canelinha", uf24);
		Municipio mun1036 = new Municipio(null, "Canoinhas", uf24);
		Municipio mun1049 = new Municipio(null, "Capão Alto", uf24);
		Municipio mun1069 = new Municipio(null, "Capinzal", uf24);
		Municipio mun1079 = new Municipio(null, "Capivari de Baixo", uf24);
		Municipio mun1183 = new Municipio(null, "Catanduvas", uf24);
		Municipio mun1202 = new Municipio(null, "Caxambu do Sul", uf24);
		Municipio mun1214 = new Municipio(null, "Celso Ramos", uf24);
		Municipio mun1235 = new Municipio(null, "Cerro Negro", uf24);
		Municipio mun1251 = new Municipio(null, "Chapadão do Lageado", uf24);
		Municipio mun1254 = new Municipio(null, "Chapecó", uf24);
		Municipio mun1288 = new Municipio(null, "Cocal do Sul", uf24);
		Municipio mun1348 = new Municipio(null, "Concórdia", uf24);
		Municipio mun1383 = new Municipio(null, "Cordilheira Alta", uf24);
		Municipio mun1401 = new Municipio(null, "Coronel Freitas", uf24);
		Municipio mun1406 = new Municipio(null, "Coronel Martins", uf24);
		Municipio mun1418 = new Municipio(null, "Correia Pinto", uf24);
		Municipio mun1429 = new Municipio(null, "Corupá", uf24);
		Municipio mun1449 = new Municipio(null, "Criciúma", uf24);
		Municipio mun1500 = new Municipio(null, "Cunha Porã", uf24);
		Municipio mun1502 = new Municipio(null, "Cunhataí", uf24);
		Municipio mun1509 = new Municipio(null, "Curitibanos", uf24);
		Municipio mun1546 = new Municipio(null, "Descanso", uf24);
		Municipio mun1563 = new Municipio(null, "Dionísio Cerqueira", uf24);
		Municipio mun1608 = new Municipio(null, "Dona Emma", uf24);
		Municipio mun1626 = new Municipio(null, "Doutor Pedrinho", uf24);
		Municipio mun1675 = new Municipio(null, "Entre Rios", uf24);
		Municipio mun1685 = new Municipio(null, "Ermo", uf24);
		Municipio mun1689 = new Municipio(null, "Erval Velho", uf24);
		Municipio mun1751 = new Municipio(null, "Faxinal dos Guedes", uf24);
		Municipio mun1795 = new Municipio(null, "Flor do Sertão", uf24);
		Municipio mun1813 = new Municipio(null, "Florianópolis", uf24);
		Municipio mun1824 = new Municipio(null, "Formosa do Sul", uf24);
		Municipio mun1831 = new Municipio(null, "Forquilhinha", uf24);
		Municipio mun1842 = new Municipio(null, "Fraiburgo", uf24);
		Municipio mun1865 = new Municipio(null, "Frei Rogério", uf24);
		Municipio mun1879 = new Municipio(null, "Galvão", uf24);
		Municipio mun1888 = new Municipio(null, "Garopaba", uf24);
		Municipio mun1891 = new Municipio(null, "Garuva", uf24);
		Municipio mun1892 = new Municipio(null, "Gaspar", uf24);
		Municipio mun1944 = new Municipio(null, "Governador Celso Ramos", uf24);
		Municipio mun1967 = new Municipio(null, "Grão Pará", uf24);
		Municipio mun1970 = new Municipio(null, "Gravatal", uf24);
		Municipio mun1975 = new Municipio(null, "Guabiruba", uf24);
		Municipio mun2007 = new Municipio(null, "Guaraciaba", uf24);
		Municipio mun2012 = new Municipio(null, "Guaramirim", uf24);
		Municipio mun2035 = new Municipio(null, "Guarujá do Sul", uf24);
		Municipio mun2038 = new Municipio(null, "Guatambú", uf24);
		Municipio mun2058 = new Municipio(null, "Herval d'Oeste", uf24);
		Municipio mun2092 = new Municipio(null, "Ibiam", uf24);
		Municipio mun2097 = new Municipio(null, "Ibicaré", uf24);
		Municipio mun2112 = new Municipio(null, "Ibirama", uf24);
		Municipio mun2129 = new Municipio(null, "Içara", uf24);
		Municipio mun2173 = new Municipio(null, "Ilhota", uf24);
		Municipio mun2177 = new Municipio(null, "Imaruí", uf24);
		Municipio mun2181 = new Municipio(null, "Imbituba", uf24);
		Municipio mun2183 = new Municipio(null, "Imbuia", uf24);
		Municipio mun2192 = new Municipio(null, "Indaial", uf24);
		Municipio mun2217 = new Municipio(null, "Iomerê", uf24);
		Municipio mun2233 = new Municipio(null, "Ipira", uf24);
		Municipio mun2243 = new Municipio(null, "Iporã do Oeste", uf24);
		Municipio mun2249 = new Municipio(null, "Ipuaçu", uf24);
		Municipio mun2255 = new Municipio(null, "Ipumirim", uf24);
		Municipio mun2261 = new Municipio(null, "Iraceminha", uf24);
		Municipio mun2267 = new Municipio(null, "Irani", uf24);
		Municipio mun2273 = new Municipio(null, "Irati", uf24);
		Municipio mun2277 = new Municipio(null, "Irineópolis", uf24);
		Municipio mun2282 = new Municipio(null, "Itá", uf24);
		Municipio mun2320 = new Municipio(null, "Itaiópolis", uf24);
		Municipio mun2328 = new Municipio(null, "Itajaí", uf24);
		Municipio mun2367 = new Municipio(null, "Itapema", uf24);
		Municipio mun2380 = new Municipio(null, "Itapiranga", uf24);
		Municipio mun2388 = new Municipio(null, "Itapoá", uf24);
		Municipio mun2448 = new Municipio(null, "Ituporanga", uf24);
		Municipio mun2463 = new Municipio(null, "Jaborá", uf24);
		Municipio mun2479 = new Municipio(null, "Jacinto Machado", uf24);
		Municipio mun2504 = new Municipio(null, "Jaguaruna", uf24);
		Municipio mun2534 = new Municipio(null, "Jaraguá do Sul", uf24);
		Municipio mun2546 = new Municipio(null, "Jardinópolis", uf24);
		Municipio mun2584 = new Municipio(null, "Joaçaba", uf24);
		Municipio mun2606 = new Municipio(null, "Joinville", uf24);
		Municipio mun2609 = new Municipio(null, "José Boiteux", uf24);
		Municipio mun2645 = new Municipio(null, "Jupiá", uf24);
		Municipio mun2669 = new Municipio(null, "Lacerdópolis", uf24);
		Municipio mun2675 = new Municipio(null, "Lages", uf24);
		Municipio mun2718 = new Municipio(null, "Laguna", uf24);
		Municipio mun2722 = new Municipio(null, "Lajeado Grande", uf24);
		Municipio mun2749 = new Municipio(null, "Laurentino", uf24);
		Municipio mun2751 = new Municipio(null, "Lauro Muller", uf24);
		Municipio mun2759 = new Municipio(null, "Lebon Régis", uf24);
		Municipio mun2764 = new Municipio(null, "Leoberto Leal", uf24);
		Municipio mun2781 = new Municipio(null, "Lindóia do Sul", uf24);
		Municipio mun2795 = new Municipio(null, "Lontras", uf24);
		Municipio mun2813 = new Municipio(null, "Luiz Alves", uf24);
		Municipio mun2822 = new Municipio(null, "Luzerna", uf24);
		Municipio mun2845 = new Municipio(null, "Macieira", uf24);
		Municipio mun2855 = new Municipio(null, "Mafra", uf24);
		Municipio mun2865 = new Municipio(null, "Major Gercino", uf24);
		Municipio mun2868 = new Municipio(null, "Major Vieira", uf24);
		Municipio mun2915 = new Municipio(null, "Maracajá", uf24);
		Municipio mun2933 = new Municipio(null, "Maravilha", uf24);
		Municipio mun2947 = new Municipio(null, "Marema", uf24);
		Municipio mun2990 = new Municipio(null, "Massaranduba", uf24);
		Municipio mun3019 = new Municipio(null, "Matos Costa", uf24);
		Municipio mun3040 = new Municipio(null, "Meleiro", uf24);
		Municipio mun3099 = new Municipio(null, "Mirim Doce", uf24);
		Municipio mun3105 = new Municipio(null, "Modelo", uf24);
		Municipio mun3119 = new Municipio(null, "Mondaí", uf24);
		Municipio mun3145 = new Municipio(null, "Monte Carlo", uf24);
		Municipio mun3147 = new Municipio(null, "Monte Castelo", uf24);
		Municipio mun3184 = new Municipio(null, "Morro da Fumaça", uf24);
		Municipio mun3189 = new Municipio(null, "Morro Grande", uf24);
		Municipio mun3245 = new Municipio(null, "Navegantes", uf24);
		Municipio mun3313 = new Municipio(null, "Nova Erechim", uf24);
		Municipio mun3334 = new Municipio(null, "Nova Itaberaba", uf24);
		Municipio mun3379 = new Municipio(null, "Nova Trento", uf24);
		Municipio mun3384 = new Municipio(null, "Nova Veneza", uf24);
		Municipio mun3402 = new Municipio(null, "Novo Horizonte", uf24);
		Municipio mun3460 = new Municipio(null, "Orleans", uf24);
		Municipio mun3469 = new Municipio(null, "Otacílio Costa", uf24);
		Municipio mun3486 = new Municipio(null, "Ouro Verde", uf24);
		Municipio mun3488 = new Municipio(null, "Ouro", uf24);
		Municipio mun3507 = new Municipio(null, "Paial", uf24);
		Municipio mun3511 = new Municipio(null, "Painel", uf24);
		Municipio mun3520 = new Municipio(null, "Palhoça", uf24);
		Municipio mun3521 = new Municipio(null, "Palma Sola", uf24);
		Municipio mun3535 = new Municipio(null, "Palmeira", uf24);
		Municipio mun3549 = new Municipio(null, "Palmitos", uf24);
		Municipio mun3560 = new Municipio(null, "Papanduva", uf24);
		Municipio mun3577 = new Municipio(null, "Paraíso", uf24);
		Municipio mun3634 = new Municipio(null, "Passo de Torres", uf24);
		Municipio mun3637 = new Municipio(null, "Passos Maia", uf24);
		Municipio mun3673 = new Municipio(null, "Paulo Lopes", uf24);
		Municipio mun3703 = new Municipio(null, "Pedras Grandes", uf24);
		Municipio mun3734 = new Municipio(null, "Penha", uf24);
		Municipio mun3747 = new Municipio(null, "Peritiba", uf24);
		Municipio mun3757 = new Municipio(null, "Petrolândia", uf24);
		Municipio mun3768 = new Municipio(null, "Piçarras", uf24);
		Municipio mun3804 = new Municipio(null, "Pinhalzinho", uf24);
		Municipio mun3811 = new Municipio(null, "Pinheiro Preto", uf24);
		Municipio mun3850 = new Municipio(null, "Piratuba", uf24);
		Municipio mun3872 = new Municipio(null, "Planalto Alegre", uf24);
		Municipio mun3900 = new Municipio(null, "Pomerode", uf24);
		Municipio mun3914 = new Municipio(null, "Ponte Alta do Norte", uf24);
		Municipio mun3916 = new Municipio(null, "Ponte Alta", uf24);
		Municipio mun3920 = new Municipio(null, "Ponte Serrada", uf24);
		Municipio mun3947 = new Municipio(null, "Porto Belo", uf24);
		Municipio mun3970 = new Municipio(null, "Porto União", uf24);
		Municipio mun3987 = new Municipio(null, "Pouso Redondo", uf24);
		Municipio mun3995 = new Municipio(null, "Praia Grande", uf24);
		Municipio mun4010 = new Municipio(null, "Presidente Castelo Branco", uf24);
		Municipio mun4015 = new Municipio(null, "Presidente Getúlio", uf24);
		Municipio mun4026 = new Municipio(null, "Presidente Nereu", uf24);
		Municipio mun4040 = new Municipio(null, "Princesa", uf24);
		Municipio mun4076 = new Municipio(null, "Quilombo", uf24);
		Municipio mun4100 = new Municipio(null, "Rancho Queimado", uf24);
		Municipio mun4198 = new Municipio(null, "Rio das Antas", uf24);
		Municipio mun4205 = new Municipio(null, "Rio do Campo", uf24);
		Municipio mun4207 = new Municipio(null, "Rio do Oeste", uf24);
		Municipio mun4210 = new Municipio(null, "Rio do Sul", uf24);
		Municipio mun4213 = new Municipio(null, "Rio dos Cedros", uf24);
		Municipio mun4217 = new Municipio(null, "Rio Fortuna", uf24);
		Municipio mun4224 = new Municipio(null, "Rio Negrinho", uf24);
		Municipio mun4238 = new Municipio(null, "Rio Rufino", uf24);
		Municipio mun4246 = new Municipio(null, "Riqueza", uf24);
		Municipio mun4253 = new Municipio(null, "Rodeio", uf24);
		Municipio mun4263 = new Municipio(null, "Romelândia", uf24);
		Municipio mun4304 = new Municipio(null, "Salete", uf24);
		Municipio mun4317 = new Municipio(null, "Saltinho", uf24);
		Municipio mun4326 = new Municipio(null, "Salto Veloso", uf24);
		Municipio mun4338 = new Municipio(null, "Sangão", uf24);
		Municipio mun4358 = new Municipio(null, "Santa Cecília", uf24);
		Municipio mun4398 = new Municipio(null, "Santa Helena", uf24);
		Municipio mun4464 = new Municipio(null, "Santa Rosa de Lima", uf24);
		Municipio mun4469 = new Municipio(null, "Santa Rosa do Sul", uf24);
		Municipio mun4482 = new Municipio(null, "Santa Terezinha do Progresso", uf24);
		Municipio mun4486 = new Municipio(null, "Santa Terezinha", uf24);
		Municipio mun4523 = new Municipio(null, "Santiago do Sul", uf24);
		Municipio mun4526 = new Municipio(null, "Santo Amaro da Imperatriz", uf24);
		Municipio mun4586 = new Municipio(null, "São Bento do Sul", uf24);
		Municipio mun4592 = new Municipio(null, "São Bernardino", uf24);
		Municipio mun4595 = new Municipio(null, "São Bonifácio", uf24);
		Municipio mun4604 = new Municipio(null, "São Carlos", uf24);
		Municipio mun4606 = new Municipio(null, "São Cristovão do Sul", uf24);
		Municipio mun4619 = new Municipio(null, "São Domingos", uf24);
		Municipio mun4650 = new Municipio(null, "São Francisco do Sul", uf24);
		Municipio mun4680 = new Municipio(null, "São João Batista", uf24);
		Municipio mun4706 = new Municipio(null, "São João do Itaperiú", uf24);
		Municipio mun4711 = new Municipio(null, "São João do Oeste", uf24);
		Municipio mun4722 = new Municipio(null, "São João do Sul", uf24);
		Municipio mun4733 = new Municipio(null, "São Joaquim", uf24);
		Municipio mun4765 = new Municipio(null, "São José do Cedro", uf24);
		Municipio mun4766 = new Municipio(null, "São José do Cerrito", uf24);
		Municipio mun4797 = new Municipio(null, "São José", uf24);
		Municipio mun4802 = new Municipio(null, "São Lourenço do Oeste", uf24);
		Municipio mun4806 = new Municipio(null, "São Ludgero", uf24);
		Municipio mun4823 = new Municipio(null, "São Martinho", uf24);
		Municipio mun4829 = new Municipio(null, "São Miguel da Boa Vista", uf24);
		Municipio mun4841 = new Municipio(null, "São Miguel do Oeste", uf24);
		Municipio mun4860 = new Municipio(null, "São Pedro de Alcântara", uf24);
		Municipio mun4943 = new Municipio(null, "Saudades", uf24);
		Municipio mun4945 = new Municipio(null, "Schroeder", uf24);
		Municipio mun4947 = new Municipio(null, "Seara", uf24);
		Municipio mun4989 = new Municipio(null, "Serra Alta", uf24);
		Municipio mun5039 = new Municipio(null, "Siderópolis", uf24);
		Municipio mun5081 = new Municipio(null, "Sombrio", uf24);
		Municipio mun5094 = new Municipio(null, "Sul Brasil", uf24);
		Municipio mun5122 = new Municipio(null, "Taió", uf24);
		Municipio mun5137 = new Municipio(null, "Tangará", uf24);
		Municipio mun5227 = new Municipio(null, "Tigrinhos", uf24);
		Municipio mun5229 = new Municipio(null, "Tijucas", uf24);
		Municipio mun5232 = new Municipio(null, "Timbé do Sul", uf24);
		Municipio mun5234 = new Municipio(null, "Timbó Grande", uf24);
		Municipio mun5235 = new Municipio(null, "Timbó", uf24);
		Municipio mun5275 = new Municipio(null, "Três Barras", uf24);
		Municipio mun5289 = new Municipio(null, "Treviso", uf24);
		Municipio mun5290 = new Municipio(null, "Treze de Maio", uf24);
		Municipio mun5291 = new Municipio(null, "Treze Tílias", uf24);
		Municipio mun5301 = new Municipio(null, "Trombudo Central", uf24);
		Municipio mun5302 = new Municipio(null, "Tubarão", uf24);
		Municipio mun5310 = new Municipio(null, "Tunápolis", uf24);
		Municipio mun5337 = new Municipio(null, "Turvo", uf24);
		Municipio mun5375 = new Municipio(null, "União do Oeste", uf24);
		Municipio mun5392 = new Municipio(null, "Urubici", uf24);
		Municipio mun5403 = new Municipio(null, "Urupema", uf24);
		Municipio mun5405 = new Municipio(null, "Urussanga", uf24);
		Municipio mun5424 = new Municipio(null, "Vargeão", uf24);
		Municipio mun5428 = new Municipio(null, "Vargem Bonita", uf24);
		Municipio mun5433 = new Municipio(null, "Vargem", uf24);
		Municipio mun5493 = new Municipio(null, "Vidal Ramos", uf24);
		Municipio mun5494 = new Municipio(null, "Videira", uf24);
		Municipio mun5527 = new Municipio(null, "Vitor Meireles", uf24);
		Municipio mun5550 = new Municipio(null, "Witmarsum", uf24);
		Municipio mun5554 = new Municipio(null, "Xanxerê", uf24);
		Municipio mun5556 = new Municipio(null, "Xavantina", uf24);
		Municipio mun5557 = new Municipio(null, "Xaxim", uf24);
		Municipio mun5564 = new Municipio(null, "Zortéa", uf24);

		municipioRepository.saveAll(Arrays.asList(mun1027, mun1036, mun1049, mun1069, mun1079, mun1183, mun1202, mun1214, 
			mun11, mun13, mun44, mun45, mun56, mun67, mun72, mun74, 
			mun115, mun148, mun225, mun238, mun251, mun252, mun261, mun281, 
			mun1235, mun1251, mun1254, mun1288, mun1348, mun1383, mun1401, mun1406, 
			mun1418, mun1429, mun1449, mun1500, mun1502, mun1509, mun1546, mun1563, 
			mun1608, mun1626, mun1675, mun1685, mun1689, mun1751, mun1795, mun1813, 
			mun1824, mun1831, mun1842, mun1865, mun1879, mun1888, mun1891, mun1892, 
			mun1944, mun1967, mun1970, mun1975, mun2007, mun2012, mun2035, mun2038, 
			mun2058, mun2092, mun2097, mun2112, mun2129, mun2173, mun2177, mun2181, 
			mun2183, mun2192, mun2217, mun2233, mun2243, mun2249, mun2255, mun2261, 
			mun2267, mun2273, mun2277, mun2282, mun2320, mun2328, mun2367, mun2380, 
			mun2388, mun2448, mun2463, mun2479, mun2504, mun2534, mun2546, mun2584, 
			mun2606, mun2609, mun2645, mun2669, mun2675, mun2718, mun2722, mun2749, 
			mun2751, mun2759, mun2764, mun2781, mun2795, mun2813, mun2822, mun2845, 
			mun2855, mun2865, mun2868, mun2915, mun2933, mun2947, mun2990, mun3019, 
			mun292, mun340, mun342, mun386, mun400, mun404, mun406, mun420, 
			mun3040, mun3099, mun3105, mun3119, mun3145, mun3147, mun3184, mun3189, 
			mun3245, mun3313, mun3334, mun3379, mun3384, mun3402, mun3460, mun3469, 
			mun3486, mun3488, mun3507, mun3511, mun3520, mun3521, mun3535, mun3549, 
			mun3560, mun3577, mun3634, mun3637, mun3673, mun3703, mun3734, mun3747, 
			mun3757, mun3768, mun3804, mun3811, mun3850, mun3872, mun3900, mun3914, 
			mun3916, mun3920, mun3947, mun3970, mun3987, mun3995, mun4010, mun4015, 
			mun4026, mun4040, mun4076, mun4100, mun4198, mun4205, mun4207, mun4210, 
			mun4213, mun4217, mun4224, mun4238, mun4246, mun4253, mun4263, mun4304, 
			mun4317, mun4326, mun4338, mun4358, mun4398, mun4464, mun4469, mun4482, 
			mun435, mun466, mun467, mun468, mun469, mun480, mun504, mun534, 
			mun4486, mun4523, mun4526, mun4586, mun4592, mun4595, mun4604, mun4606, 
			mun4619, mun4650, mun4680, mun4706, mun4711, mun4722, mun4733, mun4765, 
			mun4766, mun4797, mun4802, mun4806, mun4823, mun4829, mun4841, mun4860, 
			mun4943, mun4945, mun4947, mun4989, mun5039, mun5081, mun5094, mun5122, 
			mun5137, mun5227, mun5229, mun5232, mun5234, mun5235, mun5275, mun5289, 
			mun5290, mun5291, mun5301, mun5302, mun5310, mun5337, mun5375, mun5392, 
			mun5403, mun5405, mun5424, mun5428, mun5433, mun5493, mun5494, mun5527, 
			mun5550, mun5554, mun5556, mun5557, mun5564, 
			mun576, mun588, mun599, mun623, mun630, mun655, mun667, mun683, 
			mun692, mun699, mun705, mun737, mun739, mun740, mun787, mun788, 
			mun832, mun881, mun911, mun927, mun958, mun960, mun968, mun995));

	}
	
	private void instanciaMunUf25(UF uf25) {
		Municipio mun206 = new Municipio(null, "Amparo de São Francisco", uf25);
		Municipio mun289 = new Municipio(null, "Aquidabã", uf25);
		Municipio mun295 = new Municipio(null, "Aracaju", uf25);
		Municipio mun357 = new Municipio(null, "Arauá", uf25);
		Municipio mun369 = new Municipio(null, "Areia Branca", uf25);
		Municipio mun530 = new Municipio(null, "Barra dos Coqueiros", uf25);
		Municipio mun722 = new Municipio(null, "Boquim", uf25);
		Municipio mun773 = new Municipio(null, "Brejo Grande", uf25);
		Municipio mun965 = new Municipio(null, "Campo do Brito", uf25);
		Municipio mun1030 = new Municipio(null, "Canhoba", uf25);
		Municipio mun1032 = new Municipio(null, "Canindé de São Francisco", uf25);
		Municipio mun1061 = new Municipio(null, "Capela", uf25);
		Municipio mun1116 = new Municipio(null, "Carira", uf25);
		Municipio mun1137 = new Municipio(null, "Carmópolis", uf25);
		Municipio mun1210 = new Municipio(null, "Cedro de São João", uf25);
		Municipio mun1464 = new Municipio(null, "Cristinápolis", uf25);
		Municipio mun1499 = new Municipio(null, "Cumbe", uf25);
		Municipio mun1568 = new Municipio(null, "Divina Pastora", uf25);
		Municipio mun1712 = new Municipio(null, "Estância", uf25);
		Municipio mun1763 = new Municipio(null, "Feira Nova", uf25);
		Municipio mun1864 = new Municipio(null, "Frei Paulo", uf25);
		Municipio mun1885 = new Municipio(null, "Gararu", uf25);
		Municipio mun1902 = new Municipio(null, "General Maynard", uf25);
		Municipio mun1957 = new Municipio(null, "Gracho Cardoso", uf25);
		Municipio mun2167 = new Municipio(null, "Ilha das Flores", uf25);
		Municipio mun2201 = new Municipio(null, "Indiaroba", uf25);
		Municipio mun2285 = new Municipio(null, "Itabaiana", uf25);
		Municipio mun2286 = new Municipio(null, "Itabaianinha", uf25);
		Municipio mun2291 = new Municipio(null, "Itabi", uf25);
		Municipio mun2392 = new Municipio(null, "Itaporanga d'Ajuda", uf25);
		Municipio mun2523 = new Municipio(null, "Japaratuba", uf25);
		Municipio mun2527 = new Municipio(null, "Japoatã", uf25);
		Municipio mun2674 = new Municipio(null, "Lagarto", uf25);
		Municipio mun2746 = new Municipio(null, "Laranjeiras", uf25);
		Municipio mun2830 = new Municipio(null, "Macambira", uf25);
		Municipio mun2871 = new Municipio(null, "Malhada dos Bois", uf25);
		Municipio mun2873 = new Municipio(null, "Malhador", uf25);
		Municipio mun2983 = new Municipio(null, "Maruim", uf25);
		Municipio mun3112 = new Municipio(null, "Moita Bonita", uf25);
		Municipio mun3133 = new Municipio(null, "Monte Alegre de Sergipe", uf25);
		Municipio mun3222 = new Municipio(null, "Muribeca", uf25);
		Municipio mun3255 = new Municipio(null, "Neópolis", uf25);
		Municipio mun3276 = new Municipio(null, "Nossa Senhora Aparecida", uf25);
		Municipio mun3277 = new Municipio(null, "Nossa Senhora da Glória", uf25);
		Municipio mun3278 = new Municipio(null, "Nossa Senhora das Dores", uf25);
		Municipio mun3280 = new Municipio(null, "Nossa Senhora de Lourdes", uf25);
		Municipio mun3283 = new Municipio(null, "Nossa Senhora do Socorro", uf25);
		Municipio mun3496 = new Municipio(null, "Pacatuba", uf25);
		Municipio mun3693 = new Municipio(null, "Pedra Mole", uf25);
		Municipio mun3708 = new Municipio(null, "Pedrinhas", uf25);
		Municipio mun3807 = new Municipio(null, "Pinhão", uf25);
		Municipio mun3832 = new Municipio(null, "Pirambu", uf25);
		Municipio mun3890 = new Municipio(null, "Poço Redondo", uf25);
		Municipio mun3891 = new Municipio(null, "Poço Verde", uf25);
		Municipio mun3949 = new Municipio(null, "Porto da Folha", uf25);
		Municipio mun4044 = new Municipio(null, "Propriá", uf25);
		Municipio mun4136 = new Municipio(null, "Riachão do Dantas", uf25);
		Municipio mun4152 = new Municipio(null, "Riachuelo", uf25);
		Municipio mun4178 = new Municipio(null, "Ribeirópolis", uf25);
		Municipio mun4275 = new Municipio(null, "Rosário do Catete", uf25);
		Municipio mun4309 = new Municipio(null, "Salgado", uf25);
		Municipio mun4415 = new Municipio(null, "Santa Luzia do Itanhy", uf25);
		Municipio mun4465 = new Municipio(null, "Santa Rosa de Lima", uf25);
		Municipio mun4513 = new Municipio(null, "Santana do São Francisco", uf25);
		Municipio mun4527 = new Municipio(null, "Santo Amaro das Brotas", uf25);
		Municipio mun4607 = new Municipio(null, "São Cristóvão", uf25);
		Municipio mun4620 = new Municipio(null, "São Domingos", uf25);
		Municipio mun4653 = new Municipio(null, "São Francisco", uf25);
		Municipio mun4833 = new Municipio(null, "São Miguel do Aleixo", uf25);
		Municipio mun5050 = new Municipio(null, "Simão Dias", uf25);
		Municipio mun5061 = new Municipio(null, "Siriri", uf25);
		Municipio mun5192 = new Municipio(null, "Telha", uf25);
		Municipio mun5243 = new Municipio(null, "Tobias Barreto", uf25);
		Municipio mun5250 = new Municipio(null, "Tomar do Geru", uf25);
		Municipio mun5364 = new Municipio(null, "Umbaúba", uf25);

		municipioRepository.saveAll(Arrays.asList(mun1499, mun1568, mun1712, mun1763, mun1864, mun1885, mun1902, mun1957, 
			mun206, mun289, mun295, mun357, mun369, mun530, mun722, mun773, 
			mun2167, mun2201, mun2285, mun2286, mun2291, mun2392, mun2523, mun2527, 
			mun2674, mun2746, mun2830, mun2871, mun2873, mun2983, mun3112, mun3133, 
			mun3222, mun3255, mun3276, mun3277, mun3278, mun3280, mun3283, mun3496, 
			mun3693, mun3708, mun3807, mun3832, mun3890, mun3891, mun3949, mun4044, 
			mun4136, mun4152, mun4178, mun4275, mun4309, mun4415, mun4465, mun4513, 
			mun4527, mun4607, mun4620, mun4653, mun4833, mun5050, mun5061, mun5192, 
			mun5243, mun5250, mun5364, 
			mun965, mun1030, mun1032, mun1061, mun1116, mun1137, mun1210, mun1464));

	}
	
	private void instanciaMunUf26(UF uf26) {
		Municipio mun32 = new Municipio(null, "Adamantina", uf26);
		Municipio mun34 = new Municipio(null, "Adolfo", uf26);
		Municipio mun63 = new Municipio(null, "Aguaí", uf26);
		Municipio mun66 = new Municipio(null, "Águas da Prata", uf26);
		Municipio mun68 = new Municipio(null, "Águas de Lindóia", uf26);
		Municipio mun69 = new Municipio(null, "Águas de Santa Bárbara", uf26);
		Municipio mun70 = new Municipio(null, "Águas de São Pedro", uf26);
		Municipio mun78 = new Municipio(null, "Agudos", uf26);
		Municipio mun94 = new Municipio(null, "Alambari", uf26);
		Municipio mun113 = new Municipio(null, "Alfredo Marcondes", uf26);
		Municipio mun133 = new Municipio(null, "Altair", uf26);
		Municipio mun140 = new Municipio(null, "Altinópolis", uf26);
		Municipio mun146 = new Municipio(null, "Alto Alegre", uf26);
		Municipio mun170 = new Municipio(null, "Alumínio", uf26);
		Municipio mun173 = new Municipio(null, "Álvares Florence", uf26);
		Municipio mun174 = new Municipio(null, "Álvares Machado", uf26);
		Municipio mun175 = new Municipio(null, "Álvaro de Carvalho", uf26);
		Municipio mun176 = new Municipio(null, "Alvinlândia", uf26);
		Municipio mun199 = new Municipio(null, "Americana", uf26);
		Municipio mun201 = new Municipio(null, "Américo Brasiliense", uf26);
		Municipio mun202 = new Municipio(null, "Américo de Campos", uf26);
		Municipio mun209 = new Municipio(null, "Amparo", uf26);
		Municipio mun216 = new Municipio(null, "Analândia", uf26);
		Municipio mun231 = new Municipio(null, "Andradina", uf26);
		Municipio mun234 = new Municipio(null, "Angatuba", uf26);
		Municipio mun247 = new Municipio(null, "Anhembi", uf26);
		Municipio mun248 = new Municipio(null, "Anhumas", uf26);
		Municipio mun269 = new Municipio(null, "Aparecida d'Oeste", uf26);
		Municipio mun275 = new Municipio(null, "Aparecida", uf26);
		Municipio mun279 = new Municipio(null, "Apiaí", uf26);
		Municipio mun296 = new Municipio(null, "Araçariguama", uf26);
		Municipio mun300 = new Municipio(null, "Araçatuba", uf26);
		Municipio mun303 = new Municipio(null, "Araçoiaba da Serra", uf26);
		Municipio mun327 = new Municipio(null, "Aramina", uf26);
		Municipio mun328 = new Municipio(null, "Arandu", uf26);
		Municipio mun330 = new Municipio(null, "Arapeí", uf26);
		Municipio mun343 = new Municipio(null, "Araraquara", uf26);
		Municipio mun344 = new Municipio(null, "Araras", uf26);
		Municipio mun362 = new Municipio(null, "Arco-Íris", uf26);
		Municipio mun367 = new Municipio(null, "Arealva", uf26);
		Municipio mun373 = new Municipio(null, "Areias", uf26);
		Municipio mun374 = new Municipio(null, "Areiópolis", uf26);
		Municipio mun384 = new Municipio(null, "Ariranha", uf26);
		Municipio mun401 = new Municipio(null, "Artur Nogueira", uf26);
		Municipio mun403 = new Municipio(null, "Arujá", uf26);
		Municipio mun407 = new Municipio(null, "Aspásia", uf26);
		Municipio mun412 = new Municipio(null, "Assis", uf26);
		Municipio mun422 = new Municipio(null, "Atibaia", uf26);
		Municipio mun431 = new Municipio(null, "Auriflama", uf26);
		Municipio mun438 = new Municipio(null, "Avaí", uf26);
		Municipio mun439 = new Municipio(null, "Avanhandava", uf26);
		Municipio mun440 = new Municipio(null, "Avaré", uf26);
		Municipio mun451 = new Municipio(null, "Bady Bassitt", uf26);
		Municipio mun463 = new Municipio(null, "Balbinos", uf26);
		Municipio mun472 = new Municipio(null, "Bálsamo", uf26);
		Municipio mun476 = new Municipio(null, "Bananal", uf26);
		Municipio mun486 = new Municipio(null, "Barão de Antonina", uf26);
		Municipio mun499 = new Municipio(null, "Barbosa", uf26);
		Municipio mun503 = new Municipio(null, "Bariri", uf26);
		Municipio mun505 = new Municipio(null, "Barra Bonita", uf26);
		Municipio mun516 = new Municipio(null, "Barra do Chapéu", uf26);
		Municipio mun529 = new Municipio(null, "Barra do Turvo", uf26);
		Municipio mun545 = new Municipio(null, "Barretos", uf26);
		Municipio mun546 = new Municipio(null, "Barrinha", uf26);
		Municipio mun557 = new Municipio(null, "Barueri", uf26);
		Municipio mun558 = new Municipio(null, "Bastos", uf26);
		Municipio mun563 = new Municipio(null, "Batatais", uf26);
		Municipio mun565 = new Municipio(null, "Bauru", uf26);
		Municipio mun567 = new Municipio(null, "Bebedouro", uf26);
		Municipio mun603 = new Municipio(null, "Bento de Abreu", uf26);
		Municipio mun610 = new Municipio(null, "Bernardino de Campos", uf26);
		Municipio mun613 = new Municipio(null, "Bertioga", uf26);
		Municipio mun624 = new Municipio(null, "Bilac", uf26);
		Municipio mun626 = new Municipio(null, "Birigui", uf26);
		Municipio mun627 = new Municipio(null, "Biritiba-Mirim", uf26);
		Municipio mun632 = new Municipio(null, "Boa Esperança do Sul", uf26);
		Municipio mun657 = new Municipio(null, "Bocaina", uf26);
		Municipio mun663 = new Municipio(null, "Bofete", uf26);
		Municipio mun664 = new Municipio(null, "Boituva", uf26);
		Municipio mun687 = new Municipio(null, "Bom Jesus dos Perdões", uf26);
		Municipio mun700 = new Municipio(null, "Bom Sucesso de Itararé", uf26);
		Municipio mun724 = new Municipio(null, "Borá", uf26);
		Municipio mun725 = new Municipio(null, "Boracéia", uf26);
		Municipio mun728 = new Municipio(null, "Borborema", uf26);
		Municipio mun730 = new Municipio(null, "Borebi", uf26);
		Municipio mun734 = new Municipio(null, "Botucatu", uf26);
		Municipio mun742 = new Municipio(null, "Bragança Paulista", uf26);
		Municipio mun758 = new Municipio(null, "Braúna", uf26);
		Municipio mun766 = new Municipio(null, "Brejo Alegre", uf26);
		Municipio mun782 = new Municipio(null, "Brodowski", uf26);
		Municipio mun784 = new Municipio(null, "Brotas", uf26);
		Municipio mun797 = new Municipio(null, "Buri", uf26);
		Municipio mun798 = new Municipio(null, "Buritama", uf26);
		Municipio mun812 = new Municipio(null, "Buritizal", uf26);
		Municipio mun829 = new Municipio(null, "Cabrália Paulista", uf26);
		Municipio mun830 = new Municipio(null, "Cabreúva", uf26);
		Municipio mun834 = new Municipio(null, "Caçapava", uf26);
		Municipio mun850 = new Municipio(null, "Cachoeira Paulista", uf26);
		Municipio mun863 = new Municipio(null, "Caconde", uf26);
		Municipio mun875 = new Municipio(null, "Cafelândia", uf26);
		Municipio mun877 = new Municipio(null, "Caiabu", uf26);
		Municipio mun887 = new Municipio(null, "Caieiras", uf26);
		Municipio mun889 = new Municipio(null, "Caiuá", uf26);
		Municipio mun890 = new Municipio(null, "Cajamar", uf26);
		Municipio mun893 = new Municipio(null, "Cajati", uf26);
		Municipio mun897 = new Municipio(null, "Cajobi", uf26);
		Municipio mun901 = new Municipio(null, "Cajuru", uf26);
		Municipio mun943 = new Municipio(null, "Campina do Monte Alegre", uf26);
		Municipio mun952 = new Municipio(null, "Campinas", uf26);
		Municipio mun977 = new Municipio(null, "Campo Limpo Paulista", uf26);
		Municipio mun990 = new Municipio(null, "Campos do Jordão", uf26);
		Municipio mun994 = new Municipio(null, "Campos Novos Paulista", uf26);
		Municipio mun1003 = new Municipio(null, "Cananéia", uf26);
		Municipio mun1009 = new Municipio(null, "Canas", uf26);
		Municipio mun1021 = new Municipio(null, "Cândido Mota", uf26);
		Municipio mun1022 = new Municipio(null, "Cândido Rodrigues", uf26);
		Municipio mun1034 = new Municipio(null, "Canitar", uf26);
		Municipio mun1051 = new Municipio(null, "Capão Bonito", uf26);
		Municipio mun1058 = new Municipio(null, "Capela do Alto", uf26);
		Municipio mun1081 = new Municipio(null, "Capivari", uf26);
		Municipio mun1089 = new Municipio(null, "Caraguatatuba", uf26);
		Municipio mun1097 = new Municipio(null, "Carapicuíba", uf26);
		Municipio mun1108 = new Municipio(null, "Cardoso", uf26);
		Municipio mun1155 = new Municipio(null, "Casa Branca", uf26);
		Municipio mun1167 = new Municipio(null, "Cássia dos Coqueiros", uf26);
		Municipio mun1176 = new Municipio(null, "Castilho", uf26);
		Municipio mun1181 = new Municipio(null, "Catanduva", uf26);
		Municipio mun1188 = new Municipio(null, "Catiguá", uf26);
		Municipio mun1209 = new Municipio(null, "Cedral", uf26);
		Municipio mun1226 = new Municipio(null, "Cerqueira César", uf26);
		Municipio mun1227 = new Municipio(null, "Cerquilho", uf26);
		Municipio mun1236 = new Municipio(null, "Cesário Lange", uf26);
		Municipio mun1255 = new Municipio(null, "Charqueada", uf26);
		Municipio mun1259 = new Municipio(null, "Chavantes", uf26);
		Municipio mun1283 = new Municipio(null, "Clementina", uf26);
		Municipio mun1303 = new Municipio(null, "Colina", uf26);
		Municipio mun1310 = new Municipio(null, "Colômbia", uf26);
		Municipio mun1345 = new Municipio(null, "Conchal", uf26);
		Municipio mun1346 = new Municipio(null, "Conchas", uf26);
		Municipio mun1381 = new Municipio(null, "Cordeirópolis", uf26);
		Municipio mun1393 = new Municipio(null, "Coroados", uf26);
		Municipio mun1405 = new Municipio(null, "Coronel Macedo", uf26);
		Municipio mun1427 = new Municipio(null, "Corumbataí", uf26);
		Municipio mun1431 = new Municipio(null, "Cosmópolis", uf26);
		Municipio mun1432 = new Municipio(null, "Cosmorama", uf26);
		Municipio mun1436 = new Municipio(null, "Cotia", uf26);
		Municipio mun1447 = new Municipio(null, "Cravinhos", uf26);
		Municipio mun1453 = new Municipio(null, "Cristais Paulista", uf26);
		Municipio mun1477 = new Municipio(null, "Cruzália", uf26);
		Municipio mun1485 = new Municipio(null, "Cruzeiro", uf26);
		Municipio mun1489 = new Municipio(null, "Cubatão", uf26);
		Municipio mun1501 = new Municipio(null, "Cunha", uf26);
		Municipio mun1545 = new Municipio(null, "Descalvado", uf26);
		Municipio mun1552 = new Municipio(null, "Diadema", uf26);
		Municipio mun1566 = new Municipio(null, "Dirce Reis", uf26);
		Municipio mun1574 = new Municipio(null, "Divinolândia", uf26);
		Municipio mun1581 = new Municipio(null, "Dobrada", uf26);
		Municipio mun1582 = new Municipio(null, "Dois Córregos", uf26);
		Municipio mun1590 = new Municipio(null, "Dolcinópolis", uf26);
		Municipio mun1621 = new Municipio(null, "Dourado", uf26);
		Municipio mun1631 = new Municipio(null, "Dracena", uf26);
		Municipio mun1632 = new Municipio(null, "Duartina", uf26);
		Municipio mun1636 = new Municipio(null, "Dumont", uf26);
		Municipio mun1640 = new Municipio(null, "Echaporã", uf26);
		Municipio mun1648 = new Municipio(null, "Eldorado", uf26);
		Municipio mun1650 = new Municipio(null, "Elias Fausto", uf26);
		Municipio mun1652 = new Municipio(null, "Elisiário", uf26);
		Municipio mun1656 = new Municipio(null, "Embaúba", uf26);
		Municipio mun1657 = new Municipio(null, "Embu", uf26);
		Municipio mun1658 = new Municipio(null, "Embu-Guaçu", uf26);
		Municipio mun1659 = new Municipio(null, "Emilianópolis", uf26);
		Municipio mun1667 = new Municipio(null, "Engenheiro Coelho", uf26);
		Municipio mun1705 = new Municipio(null, "Espírito Santo do Pinhal", uf26);
		Municipio mun1706 = new Municipio(null, "Espírito Santo do Turvo", uf26);
		Municipio mun1714 = new Municipio(null, "Estiva Gerbi", uf26);
		Municipio mun1717 = new Municipio(null, "Estrela d'Oeste", uf26);
		Municipio mun1721 = new Municipio(null, "Estrela do Norte", uf26);
		Municipio mun1726 = new Municipio(null, "Euclides da Cunha Paulista", uf26);
		Municipio mun1746 = new Municipio(null, "Fartura", uf26);
		Municipio mun1777 = new Municipio(null, "Fernando Prestes", uf26);
		Municipio mun1778 = new Municipio(null, "Fernandópolis", uf26);
		Municipio mun1779 = new Municipio(null, "Fernão", uf26);
		Municipio mun1780 = new Municipio(null, "Ferraz de Vasconcelos", uf26);
		Municipio mun1796 = new Municipio(null, "Flora Rica", uf26);
		Municipio mun1799 = new Municipio(null, "Floreal", uf26);
		Municipio mun1814 = new Municipio(null, "Flórida Paulista", uf26);
		Municipio mun1816 = new Municipio(null, "Florínia", uf26);
		Municipio mun1843 = new Municipio(null, "Franca", uf26);
		Municipio mun1852 = new Municipio(null, "Francisco Morato", uf26);
		Municipio mun1856 = new Municipio(null, "Franco da Rocha", uf26);
		Municipio mun1874 = new Municipio(null, "Gabriel Monteiro", uf26);
		Municipio mun1876 = new Municipio(null, "Gália", uf26);
		Municipio mun1886 = new Municipio(null, "Garça", uf26);
		Municipio mun1893 = new Municipio(null, "Gastão Vidigal", uf26);
		Municipio mun1896 = new Municipio(null, "Gavião Peixoto", uf26);
		Municipio mun1903 = new Municipio(null, "General Salgado", uf26);
		Municipio mun1907 = new Municipio(null, "Getulina", uf26);
		Municipio mun1913 = new Municipio(null, "Glicério", uf26);
		Municipio mun1979 = new Municipio(null, "Guaiçara", uf26);
		Municipio mun1980 = new Municipio(null, "Guaimbê", uf26);
		Municipio mun1982 = new Municipio(null, "Guaíra", uf26);
		Municipio mun1993 = new Municipio(null, "Guapiaçu", uf26);
		Municipio mun1994 = new Municipio(null, "Guapiara", uf26);
		Municipio mun2000 = new Municipio(null, "Guará", uf26);
		Municipio mun2002 = new Municipio(null, "Guaraçaí", uf26);
		Municipio mun2004 = new Municipio(null, "Guaraci", uf26);
		Municipio mun2014 = new Municipio(null, "Guarani d'Oeste", uf26);
		Municipio mun2020 = new Municipio(null, "Guarantã", uf26);
		Municipio mun2025 = new Municipio(null, "Guararapes", uf26);
		Municipio mun2026 = new Municipio(null, "Guararema", uf26);
		Municipio mun2028 = new Municipio(null, "Guaratinguetá", uf26);
		Municipio mun2031 = new Municipio(null, "Guareí", uf26);
		Municipio mun2032 = new Municipio(null, "Guariba", uf26);
		Municipio mun2036 = new Municipio(null, "Guarujá", uf26);
		Municipio mun2037 = new Municipio(null, "Guarulhos", uf26);
		Municipio mun2039 = new Municipio(null, "Guatapará", uf26);
		Municipio mun2052 = new Municipio(null, "Guzolândia", uf26);
		Municipio mun2057 = new Municipio(null, "Herculândia", uf26);
		Municipio mun2064 = new Municipio(null, "Holambra", uf26);
		Municipio mun2068 = new Municipio(null, "Hortolândia", uf26);
		Municipio mun2074 = new Municipio(null, "Iacanga", uf26);
		Municipio mun2076 = new Municipio(null, "Iacri", uf26);
		Municipio mun2079 = new Municipio(null, "Iaras", uf26);
		Municipio mun2084 = new Municipio(null, "Ibaté", uf26);
		Municipio mun2106 = new Municipio(null, "Ibirá", uf26);
		Municipio mun2116 = new Municipio(null, "Ibirarema", uf26);
		Municipio mun2121 = new Municipio(null, "Ibitinga", uf26);
		Municipio mun2126 = new Municipio(null, "Ibiúna", uf26);
		Municipio mun2133 = new Municipio(null, "Icém", uf26);
		Municipio mun2138 = new Municipio(null, "Iepê", uf26);
		Municipio mun2141 = new Municipio(null, "Igaraçu do Tietê", uf26);
		Municipio mun2143 = new Municipio(null, "Igarapava", uf26);
		Municipio mun2150 = new Municipio(null, "Igaratá", uf26);
		Municipio mun2157 = new Municipio(null, "Iguape", uf26);
		Municipio mun2166 = new Municipio(null, "Ilha Comprida", uf26);
		Municipio mun2170 = new Municipio(null, "Ilha Solteira", uf26);
		Municipio mun2171 = new Municipio(null, "Ilhabela", uf26);
		Municipio mun2193 = new Municipio(null, "Indaiatuba", uf26);
		Municipio mun2196 = new Municipio(null, "Indiana", uf26);
		Municipio mun2199 = new Municipio(null, "Indiaporã", uf26);
		Municipio mun2216 = new Municipio(null, "Inúbia Paulista", uf26);
		Municipio mun2225 = new Municipio(null, "Ipaussu", uf26);
		Municipio mun2228 = new Municipio(null, "Iperó", uf26);
		Municipio mun2229 = new Municipio(null, "Ipeúna", uf26);
		Municipio mun2232 = new Municipio(null, "Ipiguá", uf26);
		Municipio mun2246 = new Municipio(null, "Iporanga", uf26);
		Municipio mun2248 = new Municipio(null, "Ipuã", uf26);
		Municipio mun2260 = new Municipio(null, "Iracemápolis", uf26);
		Municipio mun2268 = new Municipio(null, "Irapuã", uf26);
		Municipio mun2269 = new Municipio(null, "Irapuru", uf26);
		Municipio mun2288 = new Municipio(null, "Itaberá", uf26);
		Municipio mun2316 = new Municipio(null, "Itaí", uf26);
		Municipio mun2329 = new Municipio(null, "Itajobi", uf26);
		Municipio mun2331 = new Municipio(null, "Itaju", uf26);
		Municipio mun2349 = new Municipio(null, "Itanhaém", uf26);
		Municipio mun2355 = new Municipio(null, "Itaóca", uf26);
		Municipio mun2363 = new Municipio(null, "Itapecerica da Serra", uf26);
		Municipio mun2373 = new Municipio(null, "Itapetininga", uf26);
		Municipio mun2375 = new Municipio(null, "Itapeva", uf26);
		Municipio mun2376 = new Municipio(null, "Itapevi", uf26);
		Municipio mun2379 = new Municipio(null, "Itapira", uf26);
		Municipio mun2382 = new Municipio(null, "Itapirapuã Paulista", uf26);
		Municipio mun2389 = new Municipio(null, "Itápolis", uf26);
		Municipio mun2394 = new Municipio(null, "Itaporanga", uf26);
		Municipio mun2398 = new Municipio(null, "Itapuí", uf26);
		Municipio mun2399 = new Municipio(null, "Itapura", uf26);
		Municipio mun2401 = new Municipio(null, "Itaquaquecetuba", uf26);
		Municipio mun2408 = new Municipio(null, "Itararé", uf26);
		Municipio mun2410 = new Municipio(null, "Itariri", uf26);
		Municipio mun2416 = new Municipio(null, "Itatiba", uf26);
		Municipio mun2418 = new Municipio(null, "Itatinga", uf26);
		Municipio mun2433 = new Municipio(null, "Itirapina", uf26);
		Municipio mun2434 = new Municipio(null, "Itirapuã", uf26);
		Municipio mun2437 = new Municipio(null, "Itobi", uf26);
		Municipio mun2439 = new Municipio(null, "Itu", uf26);
		Municipio mun2446 = new Municipio(null, "Itupeva", uf26);
		Municipio mun2451 = new Municipio(null, "Ituverava", uf26);
		Municipio mun2464 = new Municipio(null, "Jaborandi", uf26);
		Municipio mun2468 = new Municipio(null, "Jaboticabal", uf26);
		Municipio mun2475 = new Municipio(null, "Jacareí", uf26);
		Municipio mun2477 = new Municipio(null, "Jaci", uf26);
		Municipio mun2487 = new Municipio(null, "Jacupiranga", uf26);
		Municipio mun2502 = new Municipio(null, "Jaguariúna", uf26);
		Municipio mun2507 = new Municipio(null, "Jales", uf26);
		Municipio mun2508 = new Municipio(null, "Jambeiro", uf26);
		Municipio mun2515 = new Municipio(null, "Jandira", uf26);
		Municipio mun2547 = new Municipio(null, "Jardinópolis", uf26);
		Municipio mun2549 = new Municipio(null, "Jarinu", uf26);
		Municipio mun2560 = new Municipio(null, "Jaú", uf26);
		Municipio mun2574 = new Municipio(null, "Jeriquara", uf26);
		Municipio mun2587 = new Municipio(null, "Joanópolis", uf26);
		Municipio mun2598 = new Municipio(null, "João Ramalho", uf26);
		Municipio mun2610 = new Municipio(null, "José Bonifácio", uf26);
		Municipio mun2634 = new Municipio(null, "Júlio Mesquita", uf26);
		Municipio mun2635 = new Municipio(null, "Jumirim", uf26);
		Municipio mun2641 = new Municipio(null, "Jundiaí", uf26);
		Municipio mun2643 = new Municipio(null, "Junqueirópolis", uf26);
		Municipio mun2646 = new Municipio(null, "Juquiá", uf26);
		Municipio mun2647 = new Municipio(null, "Juquitiba", uf26);
		Municipio mun2716 = new Municipio(null, "Lagoinha", uf26);
		Municipio mun2742 = new Municipio(null, "Laranjal Paulista", uf26);
		Municipio mun2753 = new Municipio(null, "Lavínia", uf26);
		Municipio mun2757 = new Municipio(null, "Lavrinhas", uf26);
		Municipio mun2761 = new Municipio(null, "Leme", uf26);
		Municipio mun2762 = new Municipio(null, "Lençóis Paulista", uf26);
		Municipio mun2775 = new Municipio(null, "Limeira", uf26);
		Municipio mun2782 = new Municipio(null, "Lindóia", uf26);
		Municipio mun2786 = new Municipio(null, "Lins", uf26);
		Municipio mun2796 = new Municipio(null, "Lorena", uf26);
		Municipio mun2798 = new Municipio(null, "Lourdes", uf26);
		Municipio mun2799 = new Municipio(null, "Louveira", uf26);
		Municipio mun2801 = new Municipio(null, "Lucélia", uf26);
		Municipio mun2803 = new Municipio(null, "Lucianópolis", uf26);
		Municipio mun2806 = new Municipio(null, "Luís Antônio", uf26);
		Municipio mun2815 = new Municipio(null, "Luiziânia", uf26);
		Municipio mun2818 = new Municipio(null, "Lupércio", uf26);
		Municipio mun2820 = new Municipio(null, "Lutécia", uf26);
		Municipio mun2834 = new Municipio(null, "Macatuba", uf26);
		Municipio mun2836 = new Municipio(null, "Macaubal", uf26);
		Municipio mun2838 = new Municipio(null, "Macedônia", uf26);
		Municipio mun2858 = new Municipio(null, "Magda", uf26);
		Municipio mun2862 = new Municipio(null, "Mairinque", uf26);
		Municipio mun2863 = new Municipio(null, "Mairiporã", uf26);
		Municipio mun2890 = new Municipio(null, "Manduri", uf26);
		Municipio mun2911 = new Municipio(null, "Marabá Paulista", uf26);
		Municipio mun2914 = new Municipio(null, "Maracaí", uf26);
		Municipio mun2927 = new Municipio(null, "Marapoama", uf26);
		Municipio mun2956 = new Municipio(null, "Mariápolis", uf26);
		Municipio mun2963 = new Municipio(null, "Marília", uf26);
		Municipio mun2966 = new Municipio(null, "Marinópolis", uf26);
		Municipio mun2980 = new Municipio(null, "Martinópolis", uf26);
		Municipio mun2996 = new Municipio(null, "Matão", uf26);
		Municipio mun3027 = new Municipio(null, "Mauá", uf26);
		Municipio mun3044 = new Municipio(null, "Mendonça", uf26);
		Municipio mun3047 = new Municipio(null, "Meridiano", uf26);
		Municipio mun3049 = new Municipio(null, "Mesópolis", uf26);
		Municipio mun3058 = new Municipio(null, "Miguelópolis", uf26);
		Municipio mun3071 = new Municipio(null, "Mineiros do Tietê", uf26);
		Municipio mun3074 = new Municipio(null, "Mira Estrela", uf26);
		Municipio mun3076 = new Municipio(null, "Miracatu", uf26);
		Municipio mun3088 = new Municipio(null, "Mirandópolis", uf26);
		Municipio mun3092 = new Municipio(null, "Mirante do Paranapanema", uf26);
		Municipio mun3096 = new Municipio(null, "Mirassol", uf26);
		Municipio mun3097 = new Municipio(null, "Mirassolândia", uf26);
		Municipio mun3104 = new Municipio(null, "Mococa", uf26);
		Municipio mun3109 = new Municipio(null, "Mogi das Cruzes", uf26);
		Municipio mun3110 = new Municipio(null, "Mogi Guaçu", uf26);
		Municipio mun3113 = new Municipio(null, "Moji Mirim", uf26);
		Municipio mun3116 = new Municipio(null, "Mombuca", uf26);
		Municipio mun3118 = new Municipio(null, "Monções", uf26);
		Municipio mun3120 = new Municipio(null, "Mongaguá", uf26);
		Municipio mun3135 = new Municipio(null, "Monte Alegre do Sul", uf26);
		Municipio mun3139 = new Municipio(null, "Monte Alto", uf26);
		Municipio mun3140 = new Municipio(null, "Monte Aprazível", uf26);
		Municipio mun3141 = new Municipio(null, "Monte Azul Paulista", uf26);
		Municipio mun3148 = new Municipio(null, "Monte Castelo", uf26);
		Municipio mun3153 = new Municipio(null, "Monte Mor", uf26);
		Municipio mun3159 = new Municipio(null, "Monteiro Lobato", uf26);
		Municipio mun3182 = new Municipio(null, "Morro Agudo", uf26);
		Municipio mun3194 = new Municipio(null, "Morungaba", uf26);
		Municipio mun3198 = new Municipio(null, "Motuca", uf26);
		Municipio mun3227 = new Municipio(null, "Murutinga do Sul", uf26);
		Municipio mun3233 = new Municipio(null, "Nantes", uf26);
		Municipio mun3237 = new Municipio(null, "Narandiba", uf26);
		Municipio mun3241 = new Municipio(null, "Natividade da Serra", uf26);
		Municipio mun3249 = new Municipio(null, "Nazaré Paulista", uf26);
		Municipio mun3258 = new Municipio(null, "Neves Paulista", uf26);
		Municipio mun3260 = new Municipio(null, "Nhandeara", uf26);
		Municipio mun3267 = new Municipio(null, "Nipoã", uf26);
		Municipio mun3286 = new Municipio(null, "Nova Aliança", uf26);
		Municipio mun3302 = new Municipio(null, "Nova Campina", uf26);
		Municipio mun3304 = new Municipio(null, "Nova Canaã Paulista", uf26);
		Municipio mun3308 = new Municipio(null, "Nova Castilho", uf26);
		Municipio mun3318 = new Municipio(null, "Nova Europa", uf26);
		Municipio mun3324 = new Municipio(null, "Nova Granada", uf26);
		Municipio mun3326 = new Municipio(null, "Nova Guataporanga", uf26);
		Municipio mun3331 = new Municipio(null, "Nova Independência", uf26);
		Municipio mun3340 = new Municipio(null, "Nova Luzitânia", uf26);
		Municipio mun3347 = new Municipio(null, "Nova Odessa", uf26);
		Municipio mun3388 = new Municipio(null, "Novais", uf26);
		Municipio mun3403 = new Municipio(null, "Novo Horizonte", uf26);
		Municipio mun3423 = new Municipio(null, "Nuporanga", uf26);
		Municipio mun3426 = new Municipio(null, "Ocauçu", uf26);
		Municipio mun3431 = new Municipio(null, "Óleo", uf26);
		Municipio mun3440 = new Municipio(null, "Olímpia", uf26);
		Municipio mun3452 = new Municipio(null, "Onda Verde", uf26);
		Municipio mun3454 = new Municipio(null, "Oriente", uf26);
		Municipio mun3455 = new Municipio(null, "Orindiúva", uf26);
		Municipio mun3459 = new Municipio(null, "Orlândia", uf26);
		Municipio mun3465 = new Municipio(null, "Osasco", uf26);
		Municipio mun3466 = new Municipio(null, "Oscar Bressane", uf26);
		Municipio mun3468 = new Municipio(null, "Osvaldo Cruz", uf26);
		Municipio mun3474 = new Municipio(null, "Ourinhos", uf26);
		Municipio mun3487 = new Municipio(null, "Ouro Verde", uf26);
		Municipio mun3489 = new Municipio(null, "Ouroeste", uf26);
		Municipio mun3492 = new Municipio(null, "Pacaembu", uf26);
		Municipio mun3518 = new Municipio(null, "Palestina", uf26);
		Municipio mun3525 = new Municipio(null, "Palmares Paulista", uf26);
		Municipio mun3530 = new Municipio(null, "Palmeira d'Oeste", uf26);
		Municipio mun3547 = new Municipio(null, "Palmital", uf26);
		Municipio mun3556 = new Municipio(null, "Panorama", uf26);
		Municipio mun3567 = new Municipio(null, "Paraguaçu Paulista", uf26);
		Municipio mun3572 = new Municipio(null, "Paraibuna", uf26);
		Municipio mun3578 = new Municipio(null, "Paraíso", uf26);
		Municipio mun3590 = new Municipio(null, "Paranapanema", uf26);
		Municipio mun3592 = new Municipio(null, "Paranapuã", uf26);
		Municipio mun3598 = new Municipio(null, "Parapuã", uf26);
		Municipio mun3606 = new Municipio(null, "Pardinho", uf26);
		Municipio mun3614 = new Municipio(null, "Pariquera-Açu", uf26);
		Municipio mun3615 = new Municipio(null, "Parisi", uf26);
		Municipio mun3647 = new Municipio(null, "Patrocínio Paulista", uf26);
		Municipio mun3660 = new Municipio(null, "Paulicéia", uf26);
		Municipio mun3661 = new Municipio(null, "Paulínia", uf26);
		Municipio mun3666 = new Municipio(null, "Paulistânia", uf26);
		Municipio mun3670 = new Municipio(null, "Paulo de Faria", uf26);
		Municipio mun3681 = new Municipio(null, "Pederneiras", uf26);
		Municipio mun3683 = new Municipio(null, "Pedra Bela", uf26);
		Municipio mun3698 = new Municipio(null, "Pedranópolis", uf26);
		Municipio mun3704 = new Municipio(null, "Pedregulho", uf26);
		Municipio mun3705 = new Municipio(null, "Pedreira", uf26);
		Municipio mun3707 = new Municipio(null, "Pedrinhas Paulista", uf26);
		Municipio mun3714 = new Municipio(null, "Pedro de Toledo", uf26);
		Municipio mun3731 = new Municipio(null, "Penápolis", uf26);
		Municipio mun3742 = new Municipio(null, "Pereira Barreto", uf26);
		Municipio mun3743 = new Municipio(null, "Pereiras", uf26);
		Municipio mun3753 = new Municipio(null, "Peruíbe", uf26);
		Municipio mun3762 = new Municipio(null, "Piacatu", uf26);
		Municipio mun3775 = new Municipio(null, "Piedade", uf26);
		Municipio mun3779 = new Municipio(null, "Pilar do Sul", uf26);
		Municipio mun3790 = new Municipio(null, "Pindamonhangaba", uf26);
		Municipio mun3795 = new Municipio(null, "Pindorama", uf26);
		Municipio mun3805 = new Municipio(null, "Pinhalzinho", uf26);
		Municipio mun3818 = new Municipio(null, "Piquerobi", uf26);
		Municipio mun3820 = new Municipio(null, "Piquete", uf26);
		Municipio mun3821 = new Municipio(null, "Piracaia", uf26);
		Municipio mun3824 = new Municipio(null, "Piracicaba", uf26);
		Municipio mun3829 = new Municipio(null, "Piraju", uf26);
		Municipio mun3831 = new Municipio(null, "Pirajuí", uf26);
		Municipio mun3834 = new Municipio(null, "Pirangi", uf26);
		Municipio mun3842 = new Municipio(null, "Pirapora do Bom Jesus", uf26);
		Municipio mun3844 = new Municipio(null, "Pirapozinho", uf26);
		Municipio mun3847 = new Municipio(null, "Pirassununga", uf26);
		Municipio mun3849 = new Municipio(null, "Piratininga", uf26);
		Municipio mun3861 = new Municipio(null, "Pitangueiras", uf26);
		Municipio mun3876 = new Municipio(null, "Planalto", uf26);
		Municipio mun3879 = new Municipio(null, "Platina", uf26);
		Municipio mun3880 = new Municipio(null, "Poá", uf26);
		Municipio mun3897 = new Municipio(null, "Poloni", uf26);
		Municipio mun3901 = new Municipio(null, "Pompéia", uf26);
		Municipio mun3903 = new Municipio(null, "Pongaí", uf26);
		Municipio mun3909 = new Municipio(null, "Pontal", uf26);
		Municipio mun3911 = new Municipio(null, "Pontalinda", uf26);
		Municipio mun3922 = new Municipio(null, "Pontes Gestal", uf26);
		Municipio mun3927 = new Municipio(null, "Populina", uf26);
		Municipio mun3929 = new Municipio(null, "Porangaba", uf26);
		Municipio mun3956 = new Municipio(null, "Porto Feliz", uf26);
		Municipio mun3957 = new Municipio(null, "Porto Ferreira", uf26);
		Municipio mun3980 = new Municipio(null, "Potim", uf26);
		Municipio mun3982 = new Municipio(null, "Potirendaba", uf26);
		Municipio mun3989 = new Municipio(null, "Pracinha", uf26);
		Municipio mun3993 = new Municipio(null, "Pradópolis", uf26);
		Municipio mun3996 = new Municipio(null, "Praia Grande", uf26);
		Municipio mun4003 = new Municipio(null, "Pratânia", uf26);
		Municipio mun4006 = new Municipio(null, "Presidente Alves", uf26);
		Municipio mun4008 = new Municipio(null, "Presidente Bernardes", uf26);
		Municipio mun4013 = new Municipio(null, "Presidente Epitácio", uf26);
		Municipio mun4028 = new Municipio(null, "Presidente Prudente", uf26);
		Municipio mun4032 = new Municipio(null, "Presidente Venceslau", uf26);
		Municipio mun4043 = new Municipio(null, "Promissão", uf26);
		Municipio mun4052 = new Municipio(null, "Quadra", uf26);
		Municipio mun4056 = new Municipio(null, "Quatá", uf26);
		Municipio mun4069 = new Municipio(null, "Queiroz", uf26);
		Municipio mun4070 = new Municipio(null, "Queluz", uf26);
		Municipio mun4078 = new Municipio(null, "Quintana", uf26);
		Municipio mun4095 = new Municipio(null, "Rafard", uf26);
		Municipio mun4097 = new Municipio(null, "Rancharia", uf26);
		Municipio mun4109 = new Municipio(null, "Redenção da Serra", uf26);
		Municipio mun4116 = new Municipio(null, "Regente Feijó", uf26);
		Municipio mun4117 = new Municipio(null, "Reginópolis", uf26);
		Municipio mun4118 = new Municipio(null, "Registro", uf26);
		Municipio mun4132 = new Municipio(null, "Restinga", uf26);
		Municipio mun4160 = new Municipio(null, "Ribeira", uf26);
		Municipio mun4161 = new Municipio(null, "Ribeirão Bonito", uf26);
		Municipio mun4162 = new Municipio(null, "Ribeirão Branco", uf26);
		Municipio mun4165 = new Municipio(null, "Ribeirão Corrente", uf26);
		Municipio mun4169 = new Municipio(null, "Ribeirão do Sul", uf26);
		Municipio mun4170 = new Municipio(null, "Ribeirão dos Índios", uf26);
		Municipio mun4171 = new Municipio(null, "Ribeirão Grande", uf26);
		Municipio mun4172 = new Municipio(null, "Ribeirão Pires", uf26);
		Municipio mun4173 = new Municipio(null, "Ribeirão Preto", uf26);
		Municipio mun4179 = new Municipio(null, "Rifaina", uf26);
		Municipio mun4180 = new Municipio(null, "Rincão", uf26);
		Municipio mun4181 = new Municipio(null, "Rinópolis", uf26);
		Municipio mun4195 = new Municipio(null, "Rio Claro", uf26);
		Municipio mun4201 = new Municipio(null, "Rio das Pedras", uf26);
		Municipio mun4218 = new Municipio(null, "Rio Grande da Serra", uf26);
		Municipio mun4244 = new Municipio(null, "Riolândia", uf26);
		Municipio mun4248 = new Municipio(null, "Riversul", uf26);
		Municipio mun4273 = new Municipio(null, "Rosana", uf26);
		Municipio mun4280 = new Municipio(null, "Roseira", uf26);
		Municipio mun4283 = new Municipio(null, "Rubiácea", uf26);
		Municipio mun4286 = new Municipio(null, "Rubinéia", uf26);
		Municipio mun4293 = new Municipio(null, "Sabino", uf26);
		Municipio mun4298 = new Municipio(null, "Sagres", uf26);
		Municipio mun4301 = new Municipio(null, "Sales Oliveira", uf26);
		Municipio mun4302 = new Municipio(null, "Sales", uf26);
		Municipio mun4303 = new Municipio(null, "Salesópolis", uf26);
		Municipio mun4315 = new Municipio(null, "Salmourão", uf26);
		Municipio mun4318 = new Municipio(null, "Saltinho", uf26);
		Municipio mun4320 = new Municipio(null, "Salto de Pirapora", uf26);
		Municipio mun4325 = new Municipio(null, "Salto Grande", uf26);
		Municipio mun4327 = new Municipio(null, "Salto", uf26);
		Municipio mun4337 = new Municipio(null, "Sandovalina", uf26);
		Municipio mun4340 = new Municipio(null, "Santa Adélia", uf26);
		Municipio mun4341 = new Municipio(null, "Santa Albertina", uf26);
		Municipio mun4343 = new Municipio(null, "Santa Bárbara d'Oeste", uf26);
		Municipio mun4352 = new Municipio(null, "Santa Branca", uf26);
		Municipio mun4359 = new Municipio(null, "Santa Clara d'Oeste", uf26);
		Municipio mun4363 = new Municipio(null, "Santa Cruz da Conceição", uf26);
		Municipio mun4364 = new Municipio(null, "Santa Cruz da Esperança", uf26);
		Municipio mun4366 = new Municipio(null, "Santa Cruz das Palmeiras", uf26);
		Municipio mun4375 = new Municipio(null, "Santa Cruz do Rio Pardo", uf26);
		Municipio mun4383 = new Municipio(null, "Santa Ernestina", uf26);
		Municipio mun4387 = new Municipio(null, "Santa Fé do Sul", uf26);
		Municipio mun4392 = new Municipio(null, "Santa Gertrudes", uf26);
		Municipio mun4406 = new Municipio(null, "Santa Isabel", uf26);
		Municipio mun4412 = new Municipio(null, "Santa Lúcia", uf26);
		Municipio mun4426 = new Municipio(null, "Santa Maria da Serra", uf26);
		Municipio mun4442 = new Municipio(null, "Santa Mercedes", uf26);
		Municipio mun4446 = new Municipio(null, "Santa Rita d'Oeste", uf26);
		Municipio mun4456 = new Municipio(null, "Santa Rita do Passa Quatro", uf26);
		Municipio mun4466 = new Municipio(null, "Santa Rosa de Viterbo", uf26);
		Municipio mun4472 = new Municipio(null, "Santa Salete", uf26);
		Municipio mun4491 = new Municipio(null, "Santana da Ponte Pensa", uf26);
		Municipio mun4495 = new Municipio(null, "Santana de Parnaíba", uf26);
		Municipio mun4530 = new Municipio(null, "Santo Anastácio", uf26);
		Municipio mun4532 = new Municipio(null, "Santo André", uf26);
		Municipio mun4534 = new Municipio(null, "Santo Antônio da Alegria", uf26);
		Municipio mun4543 = new Municipio(null, "Santo Antônio de Posse", uf26);
		Municipio mun4545 = new Municipio(null, "Santo Antônio do Aracanguá", uf26);
		Municipio mun4553 = new Municipio(null, "Santo Antônio do Jardim", uf26);
		Municipio mun4559 = new Municipio(null, "Santo Antônio do Pinhal", uf26);
		Municipio mun4572 = new Municipio(null, "Santo Expedito", uf26);
		Municipio mun4576 = new Municipio(null, "Santópolis do Aguapeí", uf26);
		Municipio mun4578 = new Municipio(null, "Santos", uf26);
		Municipio mun4585 = new Municipio(null, "São Bento do Sapucaí", uf26);
		Municipio mun4593 = new Municipio(null, "São Bernardo do Campo", uf26);
		Municipio mun4601 = new Municipio(null, "São Caetano do Sul", uf26);
		Municipio mun4605 = new Municipio(null, "São Carlos", uf26);
		Municipio mun4654 = new Municipio(null, "São Francisco", uf26);
		Municipio mun4684 = new Municipio(null, "São João da Boa Vista", uf26);
		Municipio mun4695 = new Municipio(null, "São João das Duas Pontes", uf26);
		Municipio mun4697 = new Municipio(null, "São João de Iracema", uf26);
		Municipio mun4716 = new Municipio(null, "São João do Pau d'Alho", uf26);
		Municipio mun4730 = new Municipio(null, "São Joaquim da Barra", uf26);
		Municipio mun4739 = new Municipio(null, "São José da Bela Vista", uf26);
		Municipio mun4759 = new Municipio(null, "São José do Barreiro", uf26);
		Municipio mun4783 = new Municipio(null, "São José do Rio Pardo", uf26);
		Municipio mun4784 = new Municipio(null, "São José do Rio Preto", uf26);
		Municipio mun4792 = new Municipio(null, "São José dos Campos", uf26);
		Municipio mun4801 = new Municipio(null, "São Lourenço da Serra", uf26);
		Municipio mun4809 = new Municipio(null, "São Luís do Paraitinga", uf26);
		Municipio mun4819 = new Municipio(null, "São Manuel", uf26);
		Municipio mun4827 = new Municipio(null, "São Miguel Arcanjo", uf26);
		Municipio mun4853 = new Municipio(null, "São Paulo", uf26);
		Municipio mun4868 = new Municipio(null, "São Pedro do Turvo", uf26);
		Municipio mun4872 = new Municipio(null, "São Pedro", uf26);
		Municipio mun4881 = new Municipio(null, "São Roque", uf26);
		Municipio mun4886 = new Municipio(null, "São Sebastião da Grama", uf26);
		Municipio mun4902 = new Municipio(null, "São Sebastião", uf26);
		Municipio mun4904 = new Municipio(null, "São Simão", uf26);
		Municipio mun4921 = new Municipio(null, "São Vicente", uf26);
		Municipio mun4934 = new Municipio(null, "Sarapuí", uf26);
		Municipio mun4936 = new Municipio(null, "Sarutaiá", uf26);
		Municipio mun4948 = new Municipio(null, "Sebastianópolis do Sul", uf26);
		Municipio mun4991 = new Municipio(null, "Serra Azul", uf26);
		Municipio mun5004 = new Municipio(null, "Serra Negra", uf26);
		Municipio mun5010 = new Municipio(null, "Serrana", uf26);
		Municipio mun5030 = new Municipio(null, "Sertãozinho", uf26);
		Municipio mun5031 = new Municipio(null, "Sete Barras", uf26);
		Municipio mun5038 = new Municipio(null, "Severínia", uf26);
		Municipio mun5047 = new Municipio(null, "Silveiras", uf26);
		Municipio mun5074 = new Municipio(null, "Socorro", uf26);
		Municipio mun5084 = new Municipio(null, "Sorocaba", uf26);
		Municipio mun5093 = new Municipio(null, "Sud Mennucci", uf26);
		Municipio mun5096 = new Municipio(null, "Sumaré", uf26);
		Municipio mun5101 = new Municipio(null, "Suzanápolis", uf26);
		Municipio mun5102 = new Municipio(null, "Suzano", uf26);
		Municipio mun5105 = new Municipio(null, "Tabapuã", uf26);
		Municipio mun5106 = new Municipio(null, "Tabatinga", uf26);
		Municipio mun5109 = new Municipio(null, "Taboão da Serra", uf26);
		Municipio mun5116 = new Municipio(null, "Taciba", uf26);
		Municipio mun5118 = new Municipio(null, "Taguaí", uf26);
		Municipio mun5120 = new Municipio(null, "Taiaçu", uf26);
		Municipio mun5126 = new Municipio(null, "Taiúva", uf26);
		Municipio mun5130 = new Municipio(null, "Tambaú", uf26);
		Municipio mun5134 = new Municipio(null, "Tanabi", uf26);
		Municipio mun5155 = new Municipio(null, "Tapiraí", uf26);
		Municipio mun5157 = new Municipio(null, "Tapiratiba", uf26);
		Municipio mun5162 = new Municipio(null, "Taquaral", uf26);
		Municipio mun5166 = new Municipio(null, "Taquaritinga", uf26);
		Municipio mun5167 = new Municipio(null, "Taquarituba", uf26);
		Municipio mun5168 = new Municipio(null, "Taquarivaí", uf26);
		Municipio mun5171 = new Municipio(null, "Tarabai", uf26);
		Municipio mun5175 = new Municipio(null, "Tarumã", uf26);
		Municipio mun5178 = new Municipio(null, "Tatuí", uf26);
		Municipio mun5180 = new Municipio(null, "Taubaté", uf26);
		Municipio mun5190 = new Municipio(null, "Tejupá", uf26);
		Municipio mun5197 = new Municipio(null, "Teodoro Sampaio", uf26);
		Municipio mun5217 = new Municipio(null, "Terra Roxa", uf26);
		Municipio mun5226 = new Municipio(null, "Tietê", uf26);
		Municipio mun5236 = new Municipio(null, "Timburi", uf26);
		Municipio mun5258 = new Municipio(null, "Torre de Pedra", uf26);
		Municipio mun5260 = new Municipio(null, "Torrinha", uf26);
		Municipio mun5262 = new Municipio(null, "Trabiju", uf26);
		Municipio mun5272 = new Municipio(null, "Tremembé", uf26);
		Municipio mun5281 = new Municipio(null, "Três Fronteiras", uf26);
		Municipio mun5308 = new Municipio(null, "Tuiuti", uf26);
		Municipio mun5315 = new Municipio(null, "Tupã", uf26);
		Municipio mun5324 = new Municipio(null, "Tupi Paulista", uf26);
		Municipio mun5329 = new Municipio(null, "Turiúba", uf26);
		Municipio mun5331 = new Municipio(null, "Turmalina", uf26);
		Municipio mun5348 = new Municipio(null, "Ubarana", uf26);
		Municipio mun5350 = new Municipio(null, "Ubatuba", uf26);
		Municipio mun5353 = new Municipio(null, "Ubirajara", uf26);
		Municipio mun5356 = new Municipio(null, "Uchoa", uf26);
		Municipio mun5378 = new Municipio(null, "União Paulista", uf26);
		Municipio mun5385 = new Municipio(null, "Urânia", uf26);
		Municipio mun5387 = new Municipio(null, "Uru", uf26);
		Municipio mun5404 = new Municipio(null, "Urupês", uf26);
		Municipio mun5419 = new Municipio(null, "Valentim Gentil", uf26);
		Municipio mun5420 = new Municipio(null, "Valinhos", uf26);
		Municipio mun5422 = new Municipio(null, "Valparaíso", uf26);
		Municipio mun5430 = new Municipio(null, "Vargem Grande do Sul", uf26);
		Municipio mun5431 = new Municipio(null, "Vargem Grande Paulista", uf26);
		Municipio mun5434 = new Municipio(null, "Vargem", uf26);
		Municipio mun5448 = new Municipio(null, "Várzea Paulista", uf26);
		Municipio mun5463 = new Municipio(null, "Vera Cruz", uf26);
		Municipio mun5513 = new Municipio(null, "Vinhedo", uf26);
		Municipio mun5514 = new Municipio(null, "Viradouro", uf26);
		Municipio mun5522 = new Municipio(null, "Vista Alegre do Alto", uf26);
		Municipio mun5528 = new Municipio(null, "Vitória Brasil", uf26);
		Municipio mun5540 = new Municipio(null, "Votorantim", uf26);
		Municipio mun5541 = new Municipio(null, "Votuporanga", uf26);
		Municipio mun5562 = new Municipio(null, "Zacarias", uf26);

		municipioRepository.saveAll(Arrays.asList(mun1003, mun1009, mun1021, mun1022, mun1034, mun1051, mun1058, mun1081, 
			mun1089, mun1097, mun1108, mun1155, mun1167, mun1176, mun1181, mun1188, 
			mun1209, mun1226, mun1227, mun1236, mun1255, mun1259, mun1283, mun1303, 
			mun1310, mun1345, mun1346, mun1381, mun1393, mun1405, mun1427, mun1431, 
			mun1432, mun1436, mun1447, mun1453, mun1477, mun1485, mun1489, mun1501, 
			mun1545, mun1552, mun1566, mun1574, mun1581, mun1582, mun1590, mun1621, 
			mun1631, mun1632, mun1636, mun1640, mun1648, mun1650, mun1652, mun1656, 
			mun1657, mun1658, mun1659, mun1667, mun1705, mun1706, mun1714, mun1717, 
			mun1721, mun1726, mun1746, mun1777, mun1778, mun1779, mun1780, mun1796, 
			mun175, mun176, mun199, mun201, mun202, mun209, mun216, mun231, 
			mun1799, mun1814, mun1816, mun1843, mun1852, mun1856, mun1874, mun1876, 
			mun1886, mun1893, mun1896, mun1903, mun1907, mun1913, mun1979, mun1980, 
			mun1982, mun1993, mun1994, mun2000, mun2002, mun2004, mun2014, mun2020, 
			mun2025, mun2026, mun2028, mun2031, mun2032, mun2036, mun2037, mun2039, 
			mun2052, mun2057, mun2064, mun2068, mun2074, mun2076, mun2079, mun2084, 
			mun2106, mun2116, mun2121, mun2126, mun2133, mun2138, mun2141, mun2143, 
			mun2150, mun2157, mun2166, mun2170, mun2171, mun2193, mun2196, mun2199, 
			mun2216, mun2225, mun2228, mun2229, mun2232, mun2246, mun2248, mun2260, 
			mun2268, mun2269, mun2288, mun2316, mun2329, mun2331, mun2349, mun2355, 
			mun234, mun247, mun248, mun269, mun275, mun279, mun296, mun300, 
			mun2363, mun2373, mun2375, mun2376, mun2379, mun2382, mun2389, mun2394, 
			mun2398, mun2399, mun2401, mun2408, mun2410, mun2416, mun2418, mun2433, 
			mun2434, mun2437, mun2439, mun2446, mun2451, mun2464, mun2468, mun2475, 
			mun2477, mun2487, mun2502, mun2507, mun2508, mun2515, mun2547, mun2549, 
			mun2560, mun2574, mun2587, mun2598, mun2610, mun2634, mun2635, mun2641, 
			mun2643, mun2646, mun2647, mun2716, mun2742, mun2753, mun2757, mun2761, 
			mun2762, mun2775, mun2782, mun2786, mun2796, mun2798, mun2799, mun2801, 
			mun2803, mun2806, mun2815, mun2818, mun2820, mun2834, mun2836, mun2838, 
			mun2858, mun2862, mun2863, mun2890, mun2911, mun2914, mun2927, mun2956, 
			mun2963, mun2966, mun2980, mun2996, mun3027, mun3044, mun3047, mun3049, 
			mun303, mun327, mun328, mun330, mun343, mun344, mun362, mun367, 
			mun3058, mun3071, mun3074, mun3076, mun3088, mun3092, mun3096, mun3097, 
			mun3104, mun3109, mun3110, mun3113, mun3116, mun3118, mun3120, mun3135, 
			mun3139, mun3140, mun3141, mun3148, mun3153, mun3159, mun3182, mun3194, 
			mun3198, mun3227, mun3233, mun3237, mun3241, mun3249, mun3258, mun3260, 
			mun32, mun34, mun63, mun66, mun68, mun69, mun70, mun78, 
			mun3267, mun3286, mun3302, mun3304, mun3308, mun3318, mun3324, mun3326, 
			mun3331, mun3340, mun3347, mun3388, mun3403, mun3423, mun3426, mun3431, 
			mun3440, mun3452, mun3454, mun3455, mun3459, mun3465, mun3466, mun3468, 
			mun3474, mun3487, mun3489, mun3492, mun3518, mun3525, mun3530, mun3547, 
			mun3556, mun3567, mun3572, mun3578, mun3590, mun3592, mun3598, mun3606, 
			mun3614, mun3615, mun3647, mun3660, mun3661, mun3666, mun3670, mun3681, 
			mun3683, mun3698, mun3704, mun3705, mun3707, mun3714, mun3731, mun3742, 
			mun373, mun374, mun384, mun401, mun403, mun407, mun412, mun422, 
			mun3743, mun3753, mun3762, mun3775, mun3779, mun3790, mun3795, mun3805, 
			mun3818, mun3820, mun3821, mun3824, mun3829, mun3831, mun3834, mun3842, 
			mun3844, mun3847, mun3849, mun3861, mun3876, mun3879, mun3880, mun3897, 
			mun3901, mun3903, mun3909, mun3911, mun3922, mun3927, mun3929, mun3956, 
			mun3957, mun3980, mun3982, mun3989, mun3993, mun3996, mun4003, mun4006, 
			mun4008, mun4013, mun4028, mun4032, mun4043, mun4052, mun4056, mun4069, 
			mun4070, mun4078, mun4095, mun4097, mun4109, mun4116, mun4117, mun4118, 
			mun4132, mun4160, mun4161, mun4162, mun4165, mun4169, mun4170, mun4171, 
			mun4172, mun4173, mun4179, mun4180, mun4181, mun4195, mun4201, mun4218, 
			mun4244, mun4248, mun4273, mun4280, mun4283, mun4286, mun4293, mun4298, 
			mun4301, mun4302, mun4303, mun4315, mun4318, mun4320, mun4325, mun4327, 
			mun431, mun438, mun439, mun440, mun451, mun463, mun472, mun476, 
			mun4337, mun4340, mun4341, mun4343, mun4352, mun4359, mun4363, mun4364, 
			mun4366, mun4375, mun4383, mun4387, mun4392, mun4406, mun4412, mun4426, 
			mun4442, mun4446, mun4456, mun4466, mun4472, mun4491, mun4495, mun4530, 
			mun4532, mun4534, mun4543, mun4545, mun4553, mun4559, mun4572, mun4576, 
			mun4578, mun4585, mun4593, mun4601, mun4605, mun4654, mun4684, mun4695, 
			mun4697, mun4716, mun4730, mun4739, mun4759, mun4783, mun4784, mun4792, 
			mun4801, mun4809, mun4819, mun4827, mun4853, mun4868, mun4872, mun4881, 
			mun486, mun499, mun503, mun505, mun516, mun529, mun545, mun546, 
			mun4886, mun4902, mun4904, mun4921, mun4934, mun4936, mun4948, mun4991, 
			mun5004, mun5010, mun5030, mun5031, mun5038, mun5047, mun5074, mun5084, 
			mun5093, mun5096, mun5101, mun5102, mun5105, mun5106, mun5109, mun5116, 
			mun5118, mun5120, mun5126, mun5130, mun5134, mun5155, mun5157, mun5162, 
			mun5166, mun5167, mun5168, mun5171, mun5175, mun5178, mun5180, mun5190, 
			mun5197, mun5217, mun5226, mun5236, mun5258, mun5260, mun5262, mun5272, 
			mun5281, mun5308, mun5315, mun5324, mun5329, mun5331, mun5348, mun5350, 
			mun5353, mun5356, mun5378, mun5385, mun5387, mun5404, mun5419, mun5420, 
			mun5422, mun5430, mun5431, mun5434, mun5448, mun5463, mun5513, mun5514, 
			mun5522, mun5528, mun5540, mun5541, mun5562, 
			mun557, mun558, mun563, mun565, mun567, mun603, mun610, mun613, 
			mun624, mun626, mun627, mun632, mun657, mun663, mun664, mun687, 
			mun700, mun724, mun725, mun728, mun730, mun734, mun742, mun758, 
			mun766, mun782, mun784, mun797, mun798, mun812, mun829, mun830, 
			mun834, mun850, mun863, mun875, mun877, mun887, mun889, mun890, 
			mun893, mun897, mun901, mun943, mun952, mun977, mun990, mun994, 
			mun94, mun113, mun133, mun140, mun146, mun170, mun173, mun174));

	}
	
	private void instanciaMunUf27(UF uf27) {
		Municipio mun16 = new Municipio(null, "Abreulândia", uf27);
		Municipio mun81 = new Municipio(null, "Aguiarnópolis", uf27);
		Municipio mun118 = new Municipio(null, "Aliança do Tocantins", uf27);
		Municipio mun121 = new Municipio(null, "Almas", uf27);
		Municipio mun184 = new Municipio(null, "Alvorada", uf27);
		Municipio mun218 = new Municipio(null, "Ananás", uf27);
		Municipio mun241 = new Municipio(null, "Angico", uf27);
		Municipio mun272 = new Municipio(null, "Aparecida do Rio Negro", uf27);
		Municipio mun311 = new Municipio(null, "Aragominas", uf27);
		Municipio mun312 = new Municipio(null, "Araguacema", uf27);
		Municipio mun313 = new Municipio(null, "Araguaçu", uf27);
		Municipio mun315 = new Municipio(null, "Araguaína", uf27);
		Municipio mun318 = new Municipio(null, "Araguanã", uf27);
		Municipio mun321 = new Municipio(null, "Araguatins", uf27);
		Municipio mun332 = new Municipio(null, "Arapoema", uf27);
		Municipio mun393 = new Municipio(null, "Arraias", uf27);
		Municipio mun424 = new Municipio(null, "Augustinópolis", uf27);
		Municipio mun434 = new Municipio(null, "Aurora do Tocantins", uf27);
		Municipio mun444 = new Municipio(null, "Axixá do Tocantins", uf27);
		Municipio mun446 = new Municipio(null, "Babaçulândia", uf27);
		Municipio mun481 = new Municipio(null, "Bandeirantes do Tocantins", uf27);
		Municipio mun523 = new Municipio(null, "Barra do Ouro", uf27);
		Municipio mun553 = new Municipio(null, "Barrolândia", uf27);
		Municipio mun612 = new Municipio(null, "Bernardo Sayão", uf27);
		Municipio mun686 = new Municipio(null, "Bom Jesus do Tocantins", uf27);
		Municipio mun750 = new Municipio(null, "Brasilândia do Tocantins", uf27);
		Municipio mun763 = new Municipio(null, "Brejinho de Nazaré", uf27);
		Municipio mun802 = new Municipio(null, "Buriti do Tocantins", uf27);
		Municipio mun855 = new Municipio(null, "Cachoeirinha", uf27);
		Municipio mun993 = new Municipio(null, "Campos Lindos", uf27);
		Municipio mun1118 = new Municipio(null, "Cariri do Tocantins", uf27);
		Municipio mun1135 = new Municipio(null, "Carmolândia", uf27);
		Municipio mun1150 = new Municipio(null, "Carrasco Bonito", uf27);
		Municipio mun1162 = new Municipio(null, "Caseara", uf27);
		Municipio mun1217 = new Municipio(null, "Centenário", uf27);
		Municipio mun1244 = new Municipio(null, "Chapada da Natividade", uf27);
		Municipio mun1245 = new Municipio(null, "Chapada de Areia", uf27);
		Municipio mun1305 = new Municipio(null, "Colinas do Tocantins", uf27);
		Municipio mun1308 = new Municipio(null, "Colméia", uf27);
		Municipio mun1319 = new Municipio(null, "Combinado", uf27);
		Municipio mun1342 = new Municipio(null, "Conceição do Tocantins", uf27);
		Municipio mun1440 = new Municipio(null, "Couto de Magalhães", uf27);
		Municipio mun1458 = new Municipio(null, "Cristalândia", uf27);
		Municipio mun1467 = new Municipio(null, "Crixás do Tocantins", uf27);
		Municipio mun1530 = new Municipio(null, "Darcinópolis", uf27);
		Municipio mun1559 = new Municipio(null, "Dianópolis", uf27);
		Municipio mun1576 = new Municipio(null, "Divinópolis do Tocantins", uf27);
		Municipio mun1585 = new Municipio(null, "Dois Irmãos do Tocantins", uf27);
		Municipio mun1635 = new Municipio(null, "Dueré", uf27);
		Municipio mun1699 = new Municipio(null, "Esperantina", uf27);
		Municipio mun1748 = new Municipio(null, "Fátima", uf27);
		Municipio mun1788 = new Municipio(null, "Figueirópolis", uf27);
		Municipio mun1789 = new Municipio(null, "Filadélfia", uf27);
		Municipio mun1826 = new Municipio(null, "Formoso do Araguaia", uf27);
		Municipio mun1833 = new Municipio(null, "Fortaleza do Tabocão", uf27);
		Municipio mun1931 = new Municipio(null, "Goianorte", uf27);
		Municipio mun1933 = new Municipio(null, "Goiatins", uf27);
		Municipio mun2009 = new Municipio(null, "Guaraí", uf27);
		Municipio mun2051 = new Municipio(null, "Gurupi", uf27);
		Municipio mun2252 = new Municipio(null, "Ipueiras", uf27);
		Municipio mun2297 = new Municipio(null, "Itacajá", uf27);
		Municipio mun2315 = new Municipio(null, "Itaguatins", uf27);
		Municipio mun2384 = new Municipio(null, "Itapiratins", uf27);
		Municipio mun2390 = new Municipio(null, "Itaporã do Tocantins", uf27);
		Municipio mun2559 = new Municipio(null, "Jaú do Tocantins", uf27);
		Municipio mun2620 = new Municipio(null, "Juarina", uf27);
		Municipio mun2684 = new Municipio(null, "Lagoa da Confusão", uf27);
		Municipio mun2697 = new Municipio(null, "Lagoa do Tocantins", uf27);
		Municipio mun2725 = new Municipio(null, "Lajeado", uf27);
		Municipio mun2752 = new Municipio(null, "Lavandeira", uf27);
		Municipio mun2789 = new Municipio(null, "Lizarda", uf27);
		Municipio mun2825 = new Municipio(null, "Luzinópolis", uf27);
		Municipio mun2955 = new Municipio(null, "Marianópolis do Tocantins", uf27);
		Municipio mun2998 = new Municipio(null, "Mateiros", uf27);
		Municipio mun3029 = new Municipio(null, "Maurilândia do Tocantins", uf27);
		Municipio mun3077 = new Municipio(null, "Miracema do Tocantins", uf27);
		Municipio mun3090 = new Municipio(null, "Miranorte", uf27);
		Municipio mun3150 = new Municipio(null, "Monte do Carmo", uf27);
		Municipio mun3156 = new Municipio(null, "Monte Santo do Tocantins", uf27);
		Municipio mun3225 = new Municipio(null, "Muricilândia", uf27);
		Municipio mun3243 = new Municipio(null, "Natividade", uf27);
		Municipio mun3250 = new Municipio(null, "Nazaré", uf27);
		Municipio mun3353 = new Municipio(null, "Nova Olinda", uf27);
		Municipio mun3368 = new Municipio(null, "Nova Rosalândia", uf27);
		Municipio mun3389 = new Municipio(null, "Novo Acordo", uf27);
		Municipio mun3391 = new Municipio(null, "Novo Alegre", uf27);
		Municipio mun3406 = new Municipio(null, "Novo Jardim", uf27);
		Municipio mun3446 = new Municipio(null, "Oliveira de Fátima", uf27);
		Municipio mun3529 = new Municipio(null, "Palmas", uf27);
		Municipio mun3538 = new Municipio(null, "Palmeirante", uf27);
		Municipio mun3540 = new Municipio(null, "Palmeiras do Tocantins", uf27);
		Municipio mun3543 = new Municipio(null, "Palmeirópolis", uf27);
		Municipio mun3576 = new Municipio(null, "Paraíso do Tocantins", uf27);
		Municipio mun3584 = new Municipio(null, "Paranã", uf27);
		Municipio mun3654 = new Municipio(null, "Pau d'Arco", uf27);
		Municipio mun3710 = new Municipio(null, "Pedro Afonso", uf27);
		Municipio mun3724 = new Municipio(null, "Peixe", uf27);
		Municipio mun3738 = new Municipio(null, "Pequizeiro", uf27);
		Municipio mun3794 = new Municipio(null, "Pindorama do Tocantins", uf27);
		Municipio mun3846 = new Municipio(null, "Piraquê", uf27);
		Municipio mun3864 = new Municipio(null, "Pium", uf27);
		Municipio mun3913 = new Municipio(null, "Ponte Alta do Bom Jesus", uf27);
		Municipio mun3915 = new Municipio(null, "Ponte Alta do Tocantins", uf27);
		Municipio mun3943 = new Municipio(null, "Porto Alegre do Tocantins", uf27);
		Municipio mun3964 = new Municipio(null, "Porto Nacional", uf27);
		Municipio mun3997 = new Municipio(null, "Praia Norte", uf27);
		Municipio mun4020 = new Municipio(null, "Presidente Kennedy", uf27);
		Municipio mun4048 = new Municipio(null, "Pugmil", uf27);
		Municipio mun4108 = new Municipio(null, "Recursolândia", uf27);
		Municipio mun4142 = new Municipio(null, "Riachinho", uf27);
		Municipio mun4197 = new Municipio(null, "Rio da Conceição", uf27);
		Municipio mun4212 = new Municipio(null, "Rio dos Bois", uf27);
		Municipio mun4239 = new Municipio(null, "Rio Sono", uf27);
		Municipio mun4333 = new Municipio(null, "Sampaio", uf27);
		Municipio mun4336 = new Municipio(null, "Sandolândia", uf27);
		Municipio mun4386 = new Municipio(null, "Santa Fé do Araguaia", uf27);
		Municipio mun4437 = new Municipio(null, "Santa Maria do Tocantins", uf27);
		Municipio mun4458 = new Municipio(null, "Santa Rita do Tocantins", uf27);
		Municipio mun4470 = new Municipio(null, "Santa Rosa do Tocantins", uf27);
		Municipio mun4478 = new Municipio(null, "Santa Tereza do Tocantins", uf27);
		Municipio mun4483 = new Municipio(null, "Santa Terezinha do Tocantins", uf27);
		Municipio mun4587 = new Municipio(null, "São Bento do Tocantins", uf27);
		Municipio mun4630 = new Municipio(null, "São Félix do Tocantins", uf27);
		Municipio mun4844 = new Municipio(null, "São Miguel do Tocantins", uf27);
		Municipio mun4882 = new Municipio(null, "São Salvador do Tocantins", uf27);
		Municipio mun4898 = new Municipio(null, "São Sebastião do Tocantins", uf27);
		Municipio mun4913 = new Municipio(null, "São Valério da Natividade", uf27);
		Municipio mun5044 = new Municipio(null, "Silvanópolis", uf27);
		Municipio mun5065 = new Municipio(null, "Sítio Novo do Tocantins", uf27);
		Municipio mun5092 = new Municipio(null, "Sucupira", uf27);
		Municipio mun5119 = new Municipio(null, "Taguatinga", uf27);
		Municipio mun5124 = new Municipio(null, "Taipas do Tocantins", uf27);
		Municipio mun5127 = new Municipio(null, "Talismã", uf27);
		Municipio mun5244 = new Municipio(null, "Tocantínia", uf27);
		Municipio mun5245 = new Municipio(null, "Tocantinópolis", uf27);
		Municipio mun5325 = new Municipio(null, "Tupirama", uf27);
		Municipio mun5326 = new Municipio(null, "Tupiratins", uf27);
		Municipio mun5544 = new Municipio(null, "Wanderlândia", uf27);
		Municipio mun5551 = new Municipio(null, "Xambioá", uf27);

		municipioRepository.saveAll(Arrays.asList(mun1150, mun1162, mun1217, mun1244, mun1245, mun1305, mun1308, mun1319, 
			mun1342, mun1440, mun1458, mun1467, mun1530, mun1559, mun1576, mun1585, 
			mun16, mun81, mun118, mun121, mun184, mun218, mun241, mun272, 
			mun1635, mun1699, mun1748, mun1788, mun1789, mun1826, mun1833, mun1931, 
			mun1933, mun2009, mun2051, mun2252, mun2297, mun2315, mun2384, mun2390, 
			mun2559, mun2620, mun2684, mun2697, mun2725, mun2752, mun2789, mun2825, 
			mun2955, mun2998, mun3029, mun3077, mun3090, mun3150, mun3156, mun3225, 
			mun311, mun312, mun313, mun315, mun318, mun321, mun332, mun393, 
			mun3243, mun3250, mun3353, mun3368, mun3389, mun3391, mun3406, mun3446, 
			mun3529, mun3538, mun3540, mun3543, mun3576, mun3584, mun3654, mun3710, 
			mun3724, mun3738, mun3794, mun3846, mun3864, mun3913, mun3915, mun3943, 
			mun3964, mun3997, mun4020, mun4048, mun4108, mun4142, mun4197, mun4212, 
			mun4239, mun4333, mun4336, mun4386, mun4437, mun4458, mun4470, mun4478, 
			mun424, mun434, mun444, mun446, mun481, mun523, mun553, mun612, 
			mun4483, mun4587, mun4630, mun4844, mun4882, mun4898, mun4913, mun5044, 
			mun5065, mun5092, mun5119, mun5124, mun5127, mun5244, mun5245, mun5325, 
			mun5326, mun5544, mun5551, 
			mun686, mun750, mun763, mun802, mun855, mun993, mun1118, mun1135));

	}

}
