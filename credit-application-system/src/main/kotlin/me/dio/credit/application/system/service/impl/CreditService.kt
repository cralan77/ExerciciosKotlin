package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.exception.BusinessException
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.IICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): IICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)

        }
        this.validNumbersInstallments(credit.numberOfInstallments)
        this.validDateFirstInstallment(credit.dayFirstInstallment)
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {

        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("creditCode $creditCode not found")

        return if (credit.customer?.id == customerId) credit
                    else throw RuntimeException("Contact Admin")
    }

    private fun validNumbersInstallments (numberInstallments: Int){
        val limitInstallments = 48

        if(numberInstallments > limitInstallments || numberInstallments == 0){
            throw BusinessException("Invalid installment number")
        }
    }

    private fun validDateFirstInstallment(dateFirstInstallment: LocalDate){
            if(dateFirstInstallment> LocalDate.now().plusMonths(3)){
                throw BusinessException("Invalid date first installment")
            }
    }
}